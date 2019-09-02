package com.rusape.rovercommunications.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class MessageParser {
	private static final Logger LOGGER = Logger.getLogger(MessageParser.class.getName());
	@Autowired
	private TelemetryMessageParser telemetryMessageParser;
	public Map<Character, String> responseParser(Character messageType, String message) {
		Map<Character, String> responseMap = null;
		if (message != null) {
			responseMap = new HashMap<Character, String>();
			String responseMessage = message.substring(1).trim();
			switch (messageType) {
			case UtilityConstants.INITIALIZATION_MESSAGE_TYPE:
				responseMap.put(messageType, responseMessage);
				break;
			case UtilityConstants.TELEMETRY_MESSAGE_TYPE:
				responseMap.put(messageType, responseMessage);
				break;
			case UtilityConstants.SUCCESS_MESSAGE_TYPE:
				responseMap.put(messageType, responseMessage);
				break;	
			case UtilityConstants.BOULDER_MESSAGE_TYPE:
				responseMap.put(messageType, responseMessage);
				break;
			case UtilityConstants.CRATER_MESSAGE_TYPE:
				responseMap.put(messageType, responseMessage);
				break;
			case UtilityConstants.KILLED_MESSAGE_TYPE:
				responseMap.put(messageType, responseMessage);
				break;
			case UtilityConstants.END_RUN_MESSAGE_TYPE:
				responseMap.put(messageType, responseMessage);
				break;	
			default:
				break;
			}

		}
		return responseMap;
	}

}
