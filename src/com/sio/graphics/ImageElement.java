package com.sio.graphics;

public class ImageElement extends AbstractElementDrawable {

	private String uri;
	
	public ImageElement(Template template) {
		super(template);
	}

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
