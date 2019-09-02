package com.rusape.rovercommunications.service.impl;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rusape.rovercommunications.model.EventsMessages;
import com.rusape.rovercommunications.pojo.MessageParser;
import com.rusape.rovercommunications.service.EventsMessagesService;
import com.rusape.rovercommunications.service.MessageReceiver;
@Component("eventsProcessor")
public class EventsMessagesProcessor implements MessageReceiver {
	@Autowired 
	private MessageParser messageParser;
	@Autowired
	private EventsMessagesService eventsMessagesService;
	private static final Logger LOGGER = Logger.getLogger(EventsMessagesProcessor.class.getName());

	@Override
	public Map<Character, String> processMessage(char messageType, String message) {
        Map<Character,String> resultMap = messageParser.responseParser(messageType,message);  
        EventsMessages eventsMessages = eventsMessagesService.proceesEventsMessages(messageType,resultMap.get(messageType));
        eventsMessagesService.save(eventsMessages);
        LOGGER.log(Level.INFO,"Saved EVENTS {0}",eventsMessages);
        return resultMap;
	}

}
