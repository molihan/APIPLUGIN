package com.sio.graphics;

import java.awt.image.BufferedImage;
import java.util.List;

public class DefaultPixelTemplateImageGenerable extends ImageGenerableHandler {

	@Override
	public BufferedImage getImageRequest(Template template) {
		if(template instanceof PixelMatrixTemplate){
			BufferedImage image = new BufferedImage(((PixelMatrixTemplate) template).getWidth(), ((PixelMatrixTemplate) template).getHeight(), BufferedImage.TYPE_3BYTE_BGR);
			List<Element> elements = template.getElements();
			for(Element element : elements){
				elementCombiner.combineRequest(element, image);
			}
			return image;
		} else {
			if(getSuccessor() != null){
				getSuccessor().getImageRequest(template);
			}
		}
		
		return null;
	}

}
