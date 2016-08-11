package com.sio.object;

import com.sio.model.DeviceUtility;
import com.sio.model.net.UDPTransceiver;

public final class APIServiceManager {

	private static UDPTransceiver transceiver;
	private static DeviceUtility devices;
	
	private static APIServiceManager instance = new APIServiceManager();
			
	private APIServiceManager() { }
	
	/**
	 * Return a concerned transceiver.
	 * @return Transceiver
	 */
	public static UDPTransceiver getTransceiver() {
		return transceiver;
	}
	
	public static void setTransceiver(com.sio.model.net.UDPTransceiver transceiver) {
		APIServiceManager.transceiver = transceiver;
	}
	
	/**
	 * Return a DeviceUtility object that allows you to get a collection of AccessPoints.
	 * @return DeviceUtility a sharing/singleton object.
	 */
	public static DeviceUtility getDevices() {
		return devices;
	}
	
	public static void setDevices(DeviceUtility devices) {
		APIServiceManager.devices = devices;
	}
	
	public static APIServiceManager getInstance(){
		return instance;
	}
	
}
