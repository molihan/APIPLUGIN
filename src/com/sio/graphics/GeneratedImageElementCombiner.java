package com.sio.graphics;

import java.awt.image.BufferedImage;

public class GeneratedImageElementCombiner extends ElementCombiner{

	@Override
	public void combineRequest(Element element, BufferedImage image) {
		if(element instanceof GeneratedImageElement){
			
		} else {
			if(getSuccessor() != null){
				getSuccessor().combineRequest(element, image);
			}
		}
	}
}
