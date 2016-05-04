package com.sio.util;

import com.sio.graphics.Template;

public interface TemplateFactory {
	public static final int PIXEL_TEMPLATE = 1;
	public static final int SEGMENT_TEMPLATE = 2;
	
	public Template createTemplate(int type);
	
}
