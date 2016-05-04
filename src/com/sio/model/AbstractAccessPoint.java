package com.sio.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractAccessPoint implements TagCollection, APCommandable{

	protected String ip;
	protected int port;

	protected Map<String, WirelessTag> tags = new HashMap<>();

	public final String getIp() {
		return ip;
	}

	public final void setIp(String ip) {
		this.ip = ip;
	}
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	@Override
	public void addTag(WirelessTag tag) {
		tags.put(tag.getMac(), tag);
	}

	@Override
	public void removeTag(WirelessTag tag) {
		tags.remove(tag.getMac());
	}

	@Override
	public WirelessTag getTag(String mac) {
		return tags.get(mac);
	}

	@Override
	public Collection<WirelessTag> getTags() {
		return tags.values();
	}

	@Override
	public boolean contains(WirelessTag tag) {
		return tags.containsValue(tag);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof AbstractAccessPoint){
			if(ip != null && ip.equalsIgnoreCase(((AbstractAccessPoint) obj).getIp())){
				return true;
			}
		}
		return false;
	}
}
