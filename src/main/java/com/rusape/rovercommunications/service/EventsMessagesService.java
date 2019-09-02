package com.rusape.rovercommunications.service;

import com.rusape.rovercommunications.model.EventsMessages;

public interface EventsMessagesService {
	
	public EventsMessages save(EventsMessages events);
	public EventsMessages proceesEventsMessages(Character msgType,String message);

}
