package com.rusape.rovercommunications.service;

import com.rusape.rovercommunications.model.EventsMessages;
import com.rusape.rovercommunications.model.InitializationMessage;
import com.rusape.rovercommunications.model.TelemetryMessage;

public interface MarsRoverMessageSenderService {
	
	public void sendMessage(InitializationMessage initialisation,TelemetryMessage telemetryMessage,EventsMessages eventMessages);

}
