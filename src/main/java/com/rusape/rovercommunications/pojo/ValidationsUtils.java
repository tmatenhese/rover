package com.rusape.rovercommunications.pojo;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class ValidationsUtils {
	private static final Logger LOGGER = Logger.getLogger(ValidationsUtils.class.getName());
	//validates the arguments expects 2 arguments an ip address and a port
	public int validateIPandPort(String... args) throws IllegalAccessException {
		if (args.length != 2) {
			LOGGER.log(Level.INFO, "Pass the server IP and Port as the command line argument");
			throw new IllegalAccessException("Expecting the ip address and the port");
		} else {
			LOGGER.log(Level.INFO, "Received the correct arguments");
			try {
				return Integer.parseInt(args[1]);
			} catch (NumberFormatException e) {
				LOGGER.log(Level.INFO, "Port needs to be a digit");
				throw new IllegalAccessException("Expecting the port to be a whole number");
			}
		}
	}
	public boolean validatePortLength(int port) {
		if(4 == String.valueOf(port).length()) {
			return true;
		}else {
			return false;
		}
	}	
}
