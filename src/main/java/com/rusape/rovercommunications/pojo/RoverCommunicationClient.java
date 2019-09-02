package com.rusape.rovercommunications.pojo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.rusape.rovercommunications.service.MessageReceiver;
import com.rusape.rovercommunications.service.impl.EndRunMessageProcessor;

@Component
public class RoverCommunicationClient implements Serializable{
	private static final long serialVersionUID = 1L;
	@Qualifier("initialisationProcessor")
	@Autowired
	private MessageReceiver initialisationProcessor;
	@Qualifier("telemetryProcessor")
	@Autowired
	private MessageReceiver telemetryProcessor;
	@Qualifier("eventsProcessor")
	@Autowired
	private MessageReceiver eventsProcessor;	
	@Autowired
	@Qualifier("endRunProcessor")
	private EndRunMessageProcessor endRunProcessor;
	private static final Logger LOGGER = Logger.getLogger(RoverCommunicationClient.class.getName());
	private Socket clientSocket;
	private PrintWriter printWriter;
	private Scanner scanner;
	private Map<Character,String> resultMap;
	@Autowired
	private ValidateControllerMessages validateControllerMessages;

	public Map<Character,String> startConnection(String ip, int port) {
		try {
			ConnectionManager.getInstance().startConnection(ip, port);
			clientSocket =  ConnectionManager.getInstance().getConnection();
			printWriter = new PrintWriter(clientSocket.getOutputStream(), true);			
		    scanner = new Scanner(new InputStreamReader(clientSocket.getInputStream()));
            while (scanner.hasNext()) {
            	scanner.useDelimiter(";");
            	String roverMessage = scanner.next();
            	if(roverMessage.startsWith("I")) {
            		resultMap = initialisationProcessor.processMessage('I',roverMessage);
            	}   
            	if(roverMessage.startsWith("T")) {
            		resultMap = telemetryProcessor.processMessage('T',roverMessage);
            	}
            	if(roverMessage.startsWith("B") | roverMessage.startsWith("C") | roverMessage.startsWith("K") | roverMessage.startsWith("S") | roverMessage.startsWith("E")) {
            		Character msgType = roverMessage.charAt(0);
            		switch(msgType) {
            		case 'B' : 
            			resultMap = eventsProcessor.processMessage('B', roverMessage);
            			break;
            		case 'C' : 
            			resultMap = eventsProcessor.processMessage('C', roverMessage);
            			break;
            		case 'K' : 
            			resultMap = eventsProcessor.processMessage('K', roverMessage);
            			break;
            		case 'S' : 
            			resultMap = eventsProcessor.processMessage('S', roverMessage);
            			break;
            		case 'E' : 
            			resultMap = endRunProcessor.processMessage('E', roverMessage);
            			break;
            		default : 
            			break;	
            		}
            		
            	}
            }
            return resultMap;
		} catch (UnknownHostException | NoRouteToHostException e) {
			LOGGER.log(Level.SEVERE,"Host does not exist exception {0}",e);
		}catch(IOException e){
			LOGGER.log(Level.SEVERE,"IO Exception {0}",e);
		}
		return resultMap;
	}	
	public  void sendNavigationCommands(String msg) {
		if(validateControllerMessages.validMessage(msg)) {
			LOGGER.log(Level.INFO, "Valid Message to Rover {0}", msg);
			printWriter.println(msg);
			printWriter.flush();			
		}else {
			LOGGER.log(Level.INFO, "Invalid message to Rover {0}", msg);			
		}

	}
}
