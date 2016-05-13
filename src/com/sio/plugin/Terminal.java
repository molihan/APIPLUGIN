package com.sio.plugin;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Set;

import com.sio.model.AbstractAccessPoint;
import com.sio.model.UtilityProvider;
/**
 * 
 * @author S
 *
 */
public abstract class Terminal implements TerminalUnit, TerminalRunnable, TerminalIO, TerminalLogger, TerminalControl{
	private String defaultOuputPath;
	
	public Terminal() {
		File temp = new File(".");
		temp = temp.getParentFile();
		temp = new File(temp, Terminal.class.getSimpleName());
		defaultOuputPath = temp.getAbsolutePath();
	}
	
	/**
	 * This function return a path. For some reasons the 'plugin' may needs a folder to organized.
	 * @return String contents the system default output folder's path.
	 */
	protected final String getOutputFolderPathString() {
		return defaultOuputPath;
	}
	/**
	 * This function return a file object. For some reasons the 'plugin' may needs a folder to organized.
	 * @return File target to the system default output folder's path.
	 */
	protected final File getOutputFolderPathFile(){
		return new File(defaultOuputPath);
	}
	/**
	 * Indicates file is already created or successfully created. If false, means not exist and could not create the folder.
	 * @return boolean if true,folder exists or created, otherwise false.
	 */
	protected final boolean initialOutputFolder(){
		boolean success = false;
		File dir = getOutputFolderPathFile();
		if(dir == null){
			success = false;
		} else {
			if(dir.exists()){
				success = true;
			} else {
				try{
					dir.mkdirs();
					success = true;
				} catch (SecurityException e){
					e.printStackTrace();
					success = false;
				}
			}
		}
		return success;
	}

	@Override
	public void afterStart() {
		
	}
	
	@Override
	public void beforeStart() {
		
	}
	
	@Override
	public void beforeStop() {
		
	}
	
	@Override
	public final Reader getConcreteReader() {
		return System.console().reader();
	}
	
	@Override
	public final Writer getConcreteWriter() {
		return System.console().writer();
	}
	
	@Override
	public Reader getReader() {
		return null;
	}
	
	@Override
	public Writer getWriter() {
		return null;
	}

	@Override
	public void log(String log) {
		
		try {
			Writer writer = getConcreteWriter();
			writer.write("#"+Thread.currentThread().getName() + "#, @" + System.currentTimeMillis() + " class[" + getClass().getSimpleName() + "]: " + log+"\r\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void log(Class<Terminal> clazz, String log) {
		try {
			Writer writer = getConcreteWriter();
			writer.write("#"+Thread.currentThread().getName() + "#, @" + System.currentTimeMillis() + " class[" + clazz.getSimpleName() + "]: " + log+"\r\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public final Set<AbstractAccessPoint> getDevices() {
		return UtilityProvider.getUtility().getAccessPoints();
	}
	
	public boolean equals(Object obj){
		if(obj != null && obj instanceof Terminal){
			if (obj.getClass().getSimpleName().equalsIgnoreCase(this.getClass().getSimpleName())) {
				return true;
			}
		}
		return false;
	}
}
