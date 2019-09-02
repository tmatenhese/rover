package com.rusape.rovercommunications.pojo;

import org.springframework.stereotype.Component;

@Component
public class ValidateControllerMessages {
	
	public boolean validMessage(String msg) {		
		if(msg!=null) {
			String message = msg.replaceAll("\\s+","").trim();
			if(message.matches("^[ablrLRV;]+$")) {
				return true;
			}
		}		
		return false;
	}

}
