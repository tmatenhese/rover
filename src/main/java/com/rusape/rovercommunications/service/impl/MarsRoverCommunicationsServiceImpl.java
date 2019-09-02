package com.rusape.rovercommunications.service.impl;

import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rusape.rovercommunications.pojo.RoverCommunicationClient;
import com.rusape.rovercommunications.service.MarsRoverCommunicationsService;
@Service
public class MarsRoverCommunicationsServiceImpl implements MarsRoverCommunicationsService {
	private static final Logger LOGGER = Logger.getLogger(MarsRoverCommunicationsServiceImpl.class.getName());
	@Autowired
	private RoverCommunicationClient roverCommunicationClient;
	//Establishes connection with Rover 
	@Override
	public Map<Character,String> connect(String ip, int port) {		
		return roverCommunicationClient.startConnection(ip, port);
	}
	
}
