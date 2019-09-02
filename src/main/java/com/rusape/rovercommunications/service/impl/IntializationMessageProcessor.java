package com.rusape.rovercommunications.service.impl;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.rusape.rovercommunications.model.InitializationMessage;
import com.rusape.rovercommunications.pojo.MessageParser;
import com.rusape.rovercommunications.service.InitializationService;
import com.rusape.rovercommunications.service.MessageReceiver;
@Component("initialisationProcessor")
public class IntializationMessageProcessor implements MessageReceiver {
	private static final Logger LOGGER = Logger.getLogger(IntializationMessageProcessor.class.getName());
	@Autowired
	private MessageParser messageParser;		
	private  InitializationService initializationService;

	@Autowired
	public IntializationMessageProcessor(InitializationService initializationService) {
		this.initializationService=initializationService;
	}
	@Override
	@Transactional
	public Map<Character,String>  processMessage(char messageType,String message) {
        Map<Character,String> resultMap = messageParser.responseParser(messageType,message);  
        LOGGER.log(Level.INFO,"<<<<<<<<<<INITIALIZATION MESSAGE>>>>>>>> "+resultMap);        
        InitializationMessage initializationMessage = initializationService.processInitialisation(resultMap.get(messageType));
        initializationMessage = initializationService.save(initializationMessage);
        initializationService.setInitializationMessage(initializationMessage);
        return resultMap;
	}

}
