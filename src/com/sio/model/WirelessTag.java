/**
 * 
 */
package com.sio.model;


/**
 * @author S.Sio
 *
 */
public abstract class WirelessTag {

	/**
	 *	Variable that contains Tag's MAC address.
	 */
	protected String mac;
	protected byte[] broadcastInfo;
	protected Tag tag;
	/**
	 * This is an abstract function that must rewrite by other sub-classes.
	 * And this function decides to use which method to send.
	 * @param data Send particular bytes to the tag.
	 */
	public abstract void write(byte[] data);
	
	public final String getMac() {
		return mac;
	}
	
	public final void setMac(String mac) {
		this.mac = mac;
	}
	
	public final byte[] getBroadcastInfo() {
		return broadcastInfo;
	}
	
	public final void setBroadcastInfo(byte[] broadcastInfo) {
		this.broadcastInfo = broadcastInfo;
	}
	/**
	 * Call this method for get Tag's properties. This object contains mostly useful data.
	 * @return
	 */
	public final Tag getTag() {
		return tag;
	}

	public final void setTag(Tag tag) {
		this.tag = tag;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof WirelessTag){
			if(((WirelessTag) obj).getMac().equalsIgnoreCase(getMac())){
				return true;
			}
		} 
		return false;
	}
}
