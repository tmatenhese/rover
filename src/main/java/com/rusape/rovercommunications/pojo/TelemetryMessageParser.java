package com.rusape.rovercommunications.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;
@Component
public class TelemetryMessageParser {
	private static final Logger LOGGER = Logger.getLogger(TelemetryMessageParser.class.getName());

	private Map<Character, String> telemetryMap;

	public Map<Character, String> getTelemetryMap() {
		return telemetryMap;
	}

	public void setTelemetryMap(Map<Character, String> telemetryMap) {
		this.telemetryMap = telemetryMap;
	}

	public Map<Character, String> getMessageMap(String responseMessage) {
		telemetryMap = new HashMap<Character, String>();
		String[] responseArray = responseMessage.split("(?=b)|(?=m)|(?=h)|(?=c)");
		for (String message : responseArray) {
			if (message.contains("b")) {
				buildMap(telemetryMap,'b', message);
			}
			else if (message.contains("m")) {
				buildMap(telemetryMap,'m', message);
			}
			else if (message.contains("c")) {
				buildMap(telemetryMap,'c', message);
			}
			else {
				buildMap(telemetryMap,'T', message);
			}
		}			
		return telemetryMap;
	}

	private Map<Character, String> buildMap(Map<Character, String> messageMap,Character messageType, String message) {
		String tempMessage = message.replace(messageType.charValue(), '\'').trim();
		String removeSpecialCharacters = tempMessage.replaceAll("\\'", "").trim();
		if (messageMap.containsKey(messageType)) {
			messageMap.put(messageType, messageMap.get(messageType) + "," + removeSpecialCharacters);
		} else {
			messageMap.put(messageType, removeSpecialCharacters);
		}
		return messageMap;
	}

}
