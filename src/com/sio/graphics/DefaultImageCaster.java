package com.sio.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import com.sio.util.ImageCasterDelegatesFactory;

public class DefaultImageCaster implements ImageCaster{
	private static CastSettingSelector castSettingSelector = ImageCasterDelegatesFactory.getCastSettingSelector();
	private static DimensionSelector dimensionSelector = ImageCasterDelegatesFactory.getDimensionSelector();
//	private static PixelRaster pixelRaster = ImageCasterDelegatesFactory.getPixelRaster();
//	private static 
	public DefaultImageCaster() { }
	
	@Override
	public byte[] cast(BufferedImage image, int modal_type) {
		byte[] dst = null;
		dst = getByte(getProperImage(image, modal_type), 
				castSettingSelector.selectStartingPoint(modal_type),
				castSettingSelector.selectDirection(modal_type), 
				castSettingSelector.selectMSB(modal_type), 
				castSettingSelector.selectInversed(modal_type), 
				castSettingSelector.selectBitPerPixel(modal_type));
		
		return dst;
	}
	
	@Override
	public BufferedImage getProperImage(BufferedImage image, int modal_type) {
		int width = dimensionSelector.getWidth(modal_type);
		int height = dimensionSelector.getHeight(modal_type);
		BufferedImage dst = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g2d = (Graphics2D) dst.getGraphics();
		g2d.drawImage(image, 0, 0, null);
		return dst;
	}
	
	public static final int HORIZONTAL = 0;
	public static final int VERTICAL = 1;
	public static final int TOPLEFT = 0;
	public static final int TOPRIGHT = 1;
	public static final int BUTTONLEFT = 2;
	public static final int BUTTONRIGHT = 3;
	@Override
	public byte[] getByte(BufferedImage image, int start_point, int direction, boolean MSB, boolean inversed, int bpp) {
//		return pixelRaster.getPixels(image, direction);
		AffineTransform transform = null;
		AffineTransformOp at = null;
		BufferedImage dst = null;
		int width = image.getWidth();
		int height = image.getHeight();
		int imageType = BufferedImage.TYPE_INT_BGR;
		double radius = 0;
		byte[] pixels = null;
		int pixels_index_roller = 0;
		int[] matrix_arries = null;
		//Rotate image. coordinator of (0,0) is on top_left.
		transform = new AffineTransform();
		
		switch(start_point){
		case TOPLEFT:
			dst = new BufferedImage(width, height, imageType);
			transform.rotate(radius);
			break;
		case TOPRIGHT:
			dst = new BufferedImage(height, width, imageType);
			radius -= Math.PI/2;
			transform.rotate(radius, width/2, width/2);
			break;
		case BUTTONLEFT:
			dst = new BufferedImage(height, width, imageType);
			radius += Math.PI/2;
			transform.rotate(radius,height/2, height/2);
			break;
		case BUTTONRIGHT:
			dst = new BufferedImage(width, height, imageType);
			radius += Math.PI;
			transform.rotate(radius, width/2, height/2);
			break;
		default:
			break;
		}
		
	
		//Rotate
		{
			at = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
			dst = at.filter(image, dst);
		}
		/*
		 * After rotate image.
		 * Getter image properties.
		 */
		int fixed_width = width<=dst.getWidth()?width:dst.getWidth();
		int fixed_height = height<=dst.getHeight()?height:dst.getHeight();
		matrix_arries = dst.getRaster().getPixels(dst.getMinX(),dst.getMinY(), fixed_width, fixed_height, matrix_arries);
		//Calculate result array
		if (matrix_arries.length % 8 != 0) {
			pixels = new byte[(matrix_arries.length / 8) + 1];
		} else {
			pixels = new byte[matrix_arries.length / 8];
		}
		
		switch (direction){
		case HORIZONTAL:
			for(int x=0; x<matrix_arries.length;){
				byte b = 0x00;
				for(int y=0; y<8; y++){
					if(matrix_arries[x] != 0) {
						b |= 0x01;
					} else {
						b &= ~0x01;
					}
					if (y < 7) {
						b <<= 1;
					}
					x++;
				}
				pixels[pixels_index_roller++] = b;
			}
			break;
		case VERTICAL:
			for(int width_roller=0; width_roller<fixed_width;width_roller++){
				for(int height_roller=0; height_roller<fixed_height;){
					byte b = 0x00;
					for(int y=0; y<8; y++){
						if(matrix_arries[(height_roller*fixed_width) + width_roller] != 0) {
							b |= 0x01;
						} else {
							b &= ~0x01;
						}
						if (y < 7) {
							b <<= 1;
						}
						height_roller++;
					}
					pixels[pixels_index_roller++] = b;
				}
			}
			break;
		default:
			break;
		}
		
		if(!MSB){
			swapByte(pixels);
		}
		if(inversed){
			inverse(pixels);
		}
		return pixels;
	}

	private byte[] swapByte(byte[] src){
		for(int x=0; x<src.length; x++){
			byte temp = 0x00;
			for(int y=0; y<8; y++){
				temp >>= 1;
				temp = (byte) (temp & 0x7f);
				if((src[x] & 0x80) == 0x80){
					temp |= 0x80;
				} 
				src[x] <<= 1;
			}
			src[x] = temp;
		}
		return src;
	}
	
	private byte[] inverse(byte[] src){
		for(int x=0; x<src.length; x++){
			src[x] = (byte) ~src[x]; 
		}
		return src;
	}
	
	
}
