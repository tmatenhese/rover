package com.rusape.rovercommunications.service;

import com.rusape.rovercommunications.model.EndRunMessages;

public interface EndRunMessageService {

	public EndRunMessages save(EndRunMessages endRunMessages);
	public EndRunMessages processEndRunMessages(String message);
}
