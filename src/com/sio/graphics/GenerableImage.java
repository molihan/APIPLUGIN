package com.sio.graphics;

import java.awt.image.BufferedImage;

public interface GenerableImage {
	public static final int BARCODE = 0;
	public static final int QRCODE = 1;
	
	public BufferedImage getBarCode(String src);
	public BufferedImage getQRCode(String src);
}
