package com.rusape.rovercommunications.pojo;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
//@Service
public class ConnectionManager {
	private static final Logger LOGGER = Logger.getLogger(ConnectionManager.class.getName());
	//private constructor prevents class from being instantiated from outside this class
	private volatile Socket socket;
	private ConnectionManager() {

	}
	//The public static method allowing access to the instance of the class
	public static ConnectionManager getInstance() {
		return ConnectionManagerHolder.INSTANCE ;
	}

    private static class ConnectionManagerHolder{
        private static final ConnectionManager INSTANCE  = new ConnectionManager();
    }
    
	//establish connection with rover
	public void startConnection(String hostName,int port) throws UnknownHostException, IOException {
		socket = new Socket(hostName, port);
		if(socket!=null) {
			socket.setTcpNoDelay(true);
			LOGGER.log(Level.INFO,"<<<<<<<<<<<<<<<<<<<<<<Connected To Rover!!!!!!!!!!!!!!!!!!!!!!>>>>>>>>>>>>>>>");
		}		
	}
	//get the existing connection
	public Socket getConnection() {
		return socket;
	}
	public void closeConnection() throws IOException {
		if(socket!=null) {
			socket.close();
		}				
	}	
}