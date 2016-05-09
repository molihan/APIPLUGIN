package com.sio.graphics;

/**
 * @author S
 *
 */
public interface DirectionChooser {
	/**
	 * en:Help to choose a direction.
	 * <br/>
	 * chn:指定一个枚举值用来刷新。
	 * 
	 * @param modal_type tag's modal(type)
	 * @return	enum number.
	 */
	public int chooseDirection(int modal_type);
	
}
