package com.sio.graphics;

import java.awt.image.BufferedImage;

public interface ImageCaster {
	
	/**
	 * en�� Bring a BufferedImage object to bytes. More detail please go and see sub-classes.
	 * chn����һ��BufferedImageת��Ϊbyte[]���� ����ʵ�ּ����ࡣ
	 * @param image BufferedImage�������һ����ת��ͼ��
	 * @return	����ͼ��ת���������ֽ�����
	 */
	public byte[] cast(BufferedImage image);
}
