package com.rusape.rovercommunications.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rusape.rovercommunications.model.EndRunMessages;
import com.rusape.rovercommunications.repository.EndRunMessagesRepository;
import com.rusape.rovercommunications.service.EndRunMessageService;
@Service
public class EndRunMessageServiceImpl implements EndRunMessageService {
	@Autowired
	private EndRunMessagesRepository endRunMessagesRepository;
	@Override
	public EndRunMessages save(EndRunMessages endRunMessages) {
		EndRunMessages endRunMessage =  endRunMessagesRepository.save(endRunMessages);
		return endRunMessage;
	}

	@Override
	public EndRunMessages processEndRunMessages(String message) {
		EndRunMessages endRunMessages = new EndRunMessages();
		if(message!=null) {
			String[] tempMsg = message.split(" ");
			endRunMessages.setEndRun('E');
			endRunMessages.setTimeStamp(new Float(tempMsg[0]));
			endRunMessages.setScore(Integer.parseInt(tempMsg[1]));
		}
		return endRunMessages;
	}

}
