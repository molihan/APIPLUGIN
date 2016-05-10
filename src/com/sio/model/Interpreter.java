package com.sio.model;

/**
 * 一个解释器接口，用于在观察者对象中作为更容易被继承者解析的对象接口。
 * 例如当获取到一个字节码后不对其字节含义进行解析，而是直接对该接口实现的其他类进行OOP的编程操作。
 * @author S
 *
 */
public interface Interpreter {
	public static final int TYPE_TAG = 1;
	/**
	 * 
	 * @return Prototype, could be any.
	 * 			Check the type (by call getType()) to ensure.<br />
	 * {
	 * <b>ENUM -> TYPE_TAG = [1] is instance of InterpretedTag.</b>   
	 * }
	 */
	public Object getPrototype();
	public void setPrototype(Object obj);
	public void setType(int type);
	public int getType();
	/**
	 * This function should be call every time new data comes. And let the interpreter to solve the data convert to entity object.
	 * @param data raw data
	 */
	public void update(String ip, int port,byte[] data);
	
}
