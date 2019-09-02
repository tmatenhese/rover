package com.rusape.rovercommunications.service.impl;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rusape.rovercommunications.model.Martian;
import com.rusape.rovercommunications.model.MartianObject;
import com.rusape.rovercommunications.model.TelemetryMessage;
import com.rusape.rovercommunications.pojo.MessageParser;
import com.rusape.rovercommunications.service.InitializationService;
import com.rusape.rovercommunications.service.MarsRoverMessageSenderService;
import com.rusape.rovercommunications.service.MessageReceiver;
import com.rusape.rovercommunications.service.TelemetryService;
@Component("telemetryProcessor")
public class TelemetryMessageProcessor implements MessageReceiver {
	private static final Logger LOGGER = Logger.getLogger(TelemetryMessageProcessor.class.getName());
	@Autowired
	private MessageParser messageParser;
	
	@Autowired
	private InitializationService initializationService;	
	
	@Autowired
	private TelemetryService telemetryService;
	@Autowired
	private MarsRoverMessageSenderService marsRoverMessageSenderService;
	@Override
	@Transactional
	public Map<Character,String> processMessage(char messageType,String message) {
		Map<Character,String>  responseMap =messageParser.responseParser(messageType,message);
        LOGGER.log(Level.INFO,"<<<<<<<<<<TELEMETRY MESSAGE>>>>>>>> "+responseMap);        
        TelemetryMessage telemetryMessage = telemetryService.processTelemetry(responseMap.get(messageType));
        telemetryMessage = telemetryService.save(telemetryMessage);
        if(responseMap.containsKey('b') | responseMap.containsKey('c')| responseMap.containsKey('h')) {
            List<MartianObject> martianObjects = telemetryService.processMartianObjectMessage(responseMap,telemetryMessage);
            telemetryService.saveAllObjects(martianObjects);
        }
        if(responseMap.containsKey('m')) {       	
            List<Martian> martians = telemetryService.processMartinEnemy(responseMap.get('m'),telemetryMessage);
            telemetryService.saveAllEnemies(martians);
        }
        //communicate with the rover
//        marsRoverMessageSenderService.sendMessage(initializationService.getInitializationMessage(), telemetryMessage, null);
        
        return responseMap;
	}

}
