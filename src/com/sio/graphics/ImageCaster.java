package com.sio.graphics;

import java.awt.image.BufferedImage;

public interface ImageCaster {
	
	/**
	 * en： Bring a BufferedImage object to bytes. More detail please go and see sub-classes.
	 * chn：将一个BufferedImage转化为byte[]对象， 具体实现见子类。
	 * @param image BufferedImage对象包含一个可转换图像。
	 * @return	经由图像转换出来的字节数组
	 */
	public byte[] cast(BufferedImage image);
}
