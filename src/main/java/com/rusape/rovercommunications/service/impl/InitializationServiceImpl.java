package com.rusape.rovercommunications.service.impl;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.rusape.rovercommunications.model.InitializationMessage;
import com.rusape.rovercommunications.repository.InitializationRepository;
import com.rusape.rovercommunications.service.InitializationService;
@Component("initializationService")
public class InitializationServiceImpl implements InitializationService {
	private static final Logger LOGGER = Logger.getLogger(InitializationServiceImpl.class.getName());
	private InitializationMessage initializationMessage;
	@Autowired
	private InitializationRepository initializationRepository;

	@Override
	public InitializationMessage findById(Long id) {
		return initializationRepository.getOne(id);
	}

	@Override
	public List<InitializationMessage> findByAll() {
		return initializationRepository.findAll();
	}

	@Override
	public InitializationMessage save(InitializationMessage initializationMessage) {
		return initializationRepository.save(initializationMessage);
	}

	@Override
	public InitializationMessage processInitialisation(String message) {
		InitializationMessage initializationMessage = new InitializationMessage();
		if(message!=null) {
			String[] responseArray = message.split(" ");
			initializationMessage.setxCoordinate(new Float(responseArray[0]));
			initializationMessage.setyCoordinate(new Float(responseArray[1]));
			initializationMessage.setTimeLimit(Integer.parseInt(responseArray[2]));
			initializationMessage.setMinimumSensorRange(new Float(responseArray[3]));
			initializationMessage.setMaximumSensorRange(new Float(responseArray[4]));
			initializationMessage.setMaximumSpeed(new Float(responseArray[5]));
			initializationMessage.setMaximumTurn(new Float(responseArray[6]));
			initializationMessage.setMaximumHardTurn(new Float(responseArray[7]));
			}
		return initializationMessage;
	}
	@Override
	public void setInitializationMessage(InitializationMessage initializationMessage) {
		this.initializationMessage=initializationMessage;		
	}

	@Override
	public InitializationMessage getInitializationMessage() {
		return initializationMessage;
	}
}
