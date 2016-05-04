package com.sio.graphics;

import java.awt.image.BufferedImage;

public class StaticTextElementCombiner extends ElementCombiner {

	@Override
	public void combineRequest(Element element, BufferedImage image) {
		if(element instanceof StaticTextElement){
			
		} else {
			if(getSuccessor() != null){
				getSuccessor().combineRequest(element, image);
			}
		}
	}

}
