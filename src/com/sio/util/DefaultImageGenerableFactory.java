package com.sio.util;

import com.sio.graphics.DefaultPixelTemplateImageGenerable;
import com.sio.graphics.DefaultSegmentTemplateImageGenerable;
import com.sio.graphics.ImageGenerableHandler;

/**
 * 责任链、享元、工厂模式
 * 
 * @author S
 *
 */
public class DefaultImageGenerableFactory implements ImageGenerableFactory{

	public ImageGenerableHandler imageGenerable;
	
	public static final DefaultImageGenerableFactory instance = new DefaultImageGenerableFactory();
	
	private DefaultImageGenerableFactory() {
		ImageGenerableHandler pixelImageGenerableHandler = new DefaultPixelTemplateImageGenerable();
		ImageGenerableHandler segmentImageGenerableHandler = new DefaultSegmentTemplateImageGenerable();
		pixelImageGenerableHandler.setImageGenerableHandler(segmentImageGenerableHandler);
		imageGenerable = pixelImageGenerableHandler;
	}

	@Override
	public ImageGenerableHandler createImageGenerable(){
		return imageGenerable;
	}
}
