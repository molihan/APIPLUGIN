package com.sio.model;

/**
 * Provides an implemented class which extends from DeviceUtility.class
 * @author S
 *
 */
public final class UtilityProvider {
	private DeviceUtility utility;
	
	private static final UtilityProvider instance = new UtilityProvider();
	private UtilityProvider(){
		
	}
	
	public static final DeviceUtility getUtility(){
		return getInstance().utility;
	}
	
	public static UtilityProvider getInstance(){
		return instance;
	}
	
	public DeviceUtility initUtility(Class<?> clazz){
		try {
			Object obj = clazz.newInstance();
			utility = (DeviceUtility) obj;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return utility;
	}
	
	public DeviceUtility initUtility(DeviceUtility object){
		utility = object;
		return utility;
	}
}
