package com.rusape.rovercommunications.service;

import java.util.Map;

public interface MessageReceiver {
	
	Map<Character,String> processMessage(char messageType,String message);

}
