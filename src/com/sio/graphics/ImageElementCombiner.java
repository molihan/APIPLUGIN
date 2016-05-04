package com.sio.graphics;

import java.awt.image.BufferedImage;

public class ImageElementCombiner extends ElementCombiner{

	@Override
	public void combineRequest(Element element, BufferedImage image) {
		if(element instanceof ImageElement){
			
		} else {
			if(getSuccessor() != null){
				getSuccessor().combineRequest(element, image);
			}
		}
	}
	
}
