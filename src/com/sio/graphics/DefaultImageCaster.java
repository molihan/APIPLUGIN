package com.sio.graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.sio.util.ImageCasterDelegatesFactory;

public class DefaultImageCaster implements ImageCaster{
	private static DirectionChooser directionChooser = ImageCasterDelegatesFactory.getDirectionChooser();
	private static DimensionSelector dimensionSelector = ImageCasterDelegatesFactory.getDimensionSelector();
	private static PixelRaster pixelRaster = ImageCasterDelegatesFactory.getPixelRaster();
//	private static 
	public DefaultImageCaster() { }
	
	@Override
	public byte[] cast(BufferedImage image, int modal_type) {
		byte[] dst = null;
		dst = getByte(getProperImage(image, modal_type), directionChooser.chooseDirection(modal_type));
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
	
	@Override
	public byte[] getByte(BufferedImage image, int direction) {
//		return pixelRaster.getPixels(image, direction);
		
		return null;
	}
	
	public static final int HORIZONTAL = 0;
	public static final int VERTICAL = 1;
	public static final int TOPLEFT = 0;
	public static final int TOPRIGHT = 1;
	public static final int BUTTONLEFT = 2;
	public static final int BUTTONRIGHT = 3;
	
	private byte[] raster(BufferedImage image, int width, int height, int start_point, int direction, boolean MSB_first, boolean inversed, int bpp){
		byte[] pixels = null;
		switch(direction){
		case HORIZONTAL:
			
			break;
		case VERTICAL:
			
			break;
		default:
			break;
		}
		if(MSB_first){
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
