package com.rusape.rovercommunications.service;

import java.util.Map;

public interface MarsRoverCommunicationsService {	
	public Map<Character,String> connect(String ip,int port);
}
