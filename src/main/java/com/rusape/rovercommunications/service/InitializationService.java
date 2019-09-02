package com.rusape.rovercommunications.service;

import java.util.List;
import com.rusape.rovercommunications.model.InitializationMessage;

public interface InitializationService {
	public InitializationMessage findById(Long id);
	public List<InitializationMessage> findByAll();
	public InitializationMessage save(InitializationMessage initializationMessage);
	public InitializationMessage processInitialisation(String initializationMessage);
	public void setInitializationMessage(InitializationMessage initializationMessage);
	public InitializationMessage getInitializationMessage();
}
