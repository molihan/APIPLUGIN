package com.sio.graphics;

public class GeneratedImageElement extends AbstractElementDrawable {
	
	private int type;
	private GenerableImage generableImage;
	private String src;
	private String refer_basic, refer_src;
	
	public GeneratedImageElement(Template template, int type) {
		super(template);
		this.type = type;
	}

	public GenerableImage getGenerableImage() {
		return generableImage;
	}

	public void setGenerableImage(GenerableImage generableImage) {
		this.generableImage = generableImage;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getRefer_basic() {
		return refer_basic;
	}

	public void setRefer_basic(String refer_basic) {
		this.refer_basic = refer_basic;
	}

	public String getRefer_src() {
		return refer_src;
	}

	public void setRefer_src(String refer_src) {
		this.refer_src = refer_src;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}


}
