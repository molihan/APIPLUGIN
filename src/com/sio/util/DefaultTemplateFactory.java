package com.sio.util;

import com.sio.graphics.PixelMatrixTemplate;
import com.sio.graphics.SegmentTemplate;
import com.sio.graphics.Template;

/**
 * ����ģ��Ĺ�����
 * @author S
 *
 */
public class DefaultTemplateFactory implements TemplateFactory{

	public static final TemplateFactory instance = new DefaultTemplateFactory();
	
	private DefaultTemplateFactory() {
		
	}

	@Override
	public Template createTemplate(int type) {
		Template template = null;
		if(TemplateFactory.PIXEL_TEMPLATE == type){
			template = new PixelMatrixTemplate();
		} else if (TemplateFactory.SEGMENT_TEMPLATE == type){
			template = new SegmentTemplate();
		}
		return template;
	}
}
