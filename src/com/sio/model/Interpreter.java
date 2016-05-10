package com.sio.model;

/**
 * һ���������ӿڣ������ڹ۲��߶�������Ϊ�����ױ��̳��߽����Ķ���ӿڡ�
 * ���統��ȡ��һ���ֽ���󲻶����ֽں�����н���������ֱ�ӶԸýӿ�ʵ�ֵ����������OOP�ı�̲�����
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
