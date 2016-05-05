package com.sio.graphics;

import java.awt.image.BufferedImage;

public interface ImageCaster {
	/**
	 * For these enum, it indicates the directions your function sampling from buffered image.
	 * 				S-----------W
	 * 				|			|
	 * 				|			|
	 * 				H-----------E
	 */
	public static final int DIRECTION_SWHE = 0;
	public static final int DIRECTION_SHWE = 1;
	public static final int DIRECTION_WSEH = 2;
	public static final int DIRECTION_WESH = 3;
	public static final int DIRECTION_HSEW = 4;
	public static final int DIRECTION_HESW = 5;
	public static final int DIRECTION_EHWS = 6;
	public static final int DIRECTION_EWHS = 7;
	
	/**
	 * en�� Bring a BufferedImage object to bytes. More detail please go and see sub-classes.
	 * 		Commonly this function will go thru getProperImage() and getByte().
	 * chn����һ��BufferedImageת��Ϊbyte[]���� ����ʵ�ּ����ࡣͨ������������������ʹ�ã��������getProperImage()��getByte().
	 * @param image	BufferedImage�������һ����ת��ͼ��
	 * 			modal_type	An enum can figure out the procedures. 
	 * @return	����ͼ��ת���������ֽ�����
	 */
	public byte[] cast(BufferedImage image,int modal_type);
	/**
	 * en�� Convert buffered image to byte array. Detail please see sub-classes.
	 * chn:������ͼƬȡģΪ���ص㣬����ʵ�ּ����ࡣ
	 * @param image
	 * @param modal_type
	 * @return
	 */
	public byte[] getByte(BufferedImage image, int modal_type);
	/**
	 * 
	 * @param image
	 * @param modal_type
	 * @return
	 */
	public BufferedImage getProperImage(BufferedImage image,int modal_type);
}
