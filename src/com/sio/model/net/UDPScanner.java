package com.sio.model.net;

/**
 * To automatically found the right netcard and run the transceiver on.
 * @author S
 *
 */
public interface UDPScanner {

	String scanUsableUDP(int port);
	
}
