package com.rusape.rovercommunications.service.impl;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rusape.rovercommunications.model.EndRunMessages;
import com.rusape.rovercommunications.pojo.MessageParser;
import com.rusape.rovercommunications.service.EndRunMessageService;
import com.rusape.rovercommunications.service.MessageReceiver;
@Component("endRunProcessor")
public class EndRunMessageProcessor implements MessageReceiver {
	@Autowired 
	private MessageParser messageParser;
	@Autowired
	private EndRunMessageService endRunMessageService;
	private static final Logger LOGGER = Logger.getLogger(EndRunMessageProcessor.class.getName());
	@Override
	public Map<Character, String> processMessage(char messageType, String message) {
		Map<Character, String> responseMap = messageParser.responseParser(messageType, message);
		EndRunMessages endRunMessages = endRunMessageService.processEndRunMessages(responseMap.get(messageType));
		endRunMessageService.save(endRunMessages);
		LOGGER.log(Level.INFO,"END OF RUN MESSAGES {0}",endRunMessages);
		return null;
	}

}
