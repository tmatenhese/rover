package com.rusape.rovercommunications.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rusape.rovercommunications.model.EventsMessages;
import com.rusape.rovercommunications.model.InitializationMessage;
import com.rusape.rovercommunications.model.TelemetryMessage;
import com.rusape.rovercommunications.pojo.RoverCommunicationClient;
import com.rusape.rovercommunications.pojo.ValidateControllerMessages;
import com.rusape.rovercommunications.service.MarsRoverMessageSenderService;
@Service
public class MarsRoverMessageSenderServiceImpl implements MarsRoverMessageSenderService {
@Autowired
private RoverCommunicationClient roverCommunicationClient;

	@Override
	public void sendMessage(InitializationMessage initialisation, TelemetryMessage telemetryMessage,
			EventsMessages eventMessages) {
		
		float maxSpeed = initialisation.getMaximumSpeed();
		float currentSpeed = telemetryMessage.getVehicleSpeed();
		
		
		//-- contstant speed going straight ahead 
		//
		//control		
		String control = telemetryMessage.getVehicleControl();
		if(currentSpeed<maxSpeed) {
//			roverCommunicationClient.sendNavigationCommands("a;");
		}
	}

}
