package com.rusape.rovercommunications.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rusape.rovercommunications.model.EventsMessages;
import com.rusape.rovercommunications.repository.EventsMessagesRepository;
import com.rusape.rovercommunications.service.EventsMessagesService;
@Service
public class EventsMessagesServiceImpl implements EventsMessagesService {
	@Autowired
	private EventsMessagesRepository eventsMessagesRepository;
	@Override
	public EventsMessages save(EventsMessages events) {
		return eventsMessagesRepository.save(events);
	}

	@Override
	public EventsMessages proceesEventsMessages(Character msgType,String message) {
		EventsMessages eventsMessages = new EventsMessages();
		if(message!=null) {
			String tempMsg = message.trim();
			eventsMessages.setMessageTag(msgType);
			eventsMessages.setTimestamp(new Float(tempMsg));			
		}
		return eventsMessages;	
	}

}
