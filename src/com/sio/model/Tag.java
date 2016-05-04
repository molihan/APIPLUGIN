package com.sio.model;
/**
 * Java Bean
 * Stock gathering data
 * @author S
 *
 */
public interface Tag {
	public static final int MODEL_213_WF = 1;
	public static final int MODEL_213_OE = 2;
	public static final int MODEL_209_WF = 3;
	public static final int MODEL_209_OE = 4;
	public static final int MODEL_213_WAREHOUSE_WF = 5;
	public static final int MODEL_213_WAREHOUSE_OE = 6;
	public static final int MODEL_209_WAREHOUSE_WF = 7;
	public static final int MODEL_209_WAREHOUSE_OE = 8;
	/*
	private String mac;
	private int type;
	private int signal;
	private String ip;
	private int batt;
	private long code_1;
	private int code_2;
	private long lastRespondTime;
	private int err;
	private int onOff;
	 */
	public String mac();
	public int model();
	public int signal();
	public String apIP();
	public int battary();
	public long code_1();
	public int code_2();
	public boolean error();
	public boolean on();
}
