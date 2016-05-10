package com.sio.model;

import java.util.HashMap;

public abstract class AbstractStreamProvider implements StreamProvider {
	public static StreamProvider streamProvider;
//	public static final HashMap<>h;
	private AbstractStreamProvider() {
		streamProvider = this;
	}

	@Override
	public StreamProvider getDefaultStreamProvider() {
		return streamProvider;
	}

	@Override
	public void setDefaultStream(StreamProvider streamProvider) {
		this.streamProvider = streamProvider;
	}

	@Override
	public void getDataQueue(int type, int port) {
		
	}

}
