package com.rusape.rovercommunications.pojo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.rusape.rovercommunications.service.MessageReceiver;

public class MessageProcessorStrategy {
	private static final Logger LOGGER = Logger.getLogger(MessageProcessorStrategy.class.getName());
	@Autowired
	private MessageReceiver messageReceiver;
	
    @SuppressWarnings("unchecked")
	public static MessageReceiver generateMessageReceiver(final char messageType) {
        String handlerClassName = generateMessageReceiverHandlerClass(messageType);
        MessageReceiver messageReceiver = null;
        try {
			final Class<? extends MessageReceiver> handlerClass = (Class<? extends MessageReceiver>) Class.forName(handlerClassName);
            try {
				messageReceiver = handlerClass.newInstance();
			} catch (InstantiationException e) {
				LOGGER.log(Level.SEVERE,"Excepion "+e);
			} catch (IllegalAccessException e) {
				LOGGER.log(Level.SEVERE,"Excepion "+e);
			}
        } catch (final ClassNotFoundException e) {
        	LOGGER.log(Level.SEVERE,"Excepion "+e);
        }
        return messageReceiver;
    }

    private static String generateMessageReceiverHandlerClass(char messageType) {
        String handlerClass;
        switch (messageType) {
            case UtilityConstants.INITIALIZATION_MESSAGE_TYPE:
                handlerClass = UtilityConstants.INITIALISATION_CLASS;
                break;
            case UtilityConstants.TELEMETRY_MESSAGE_TYPE:
            	handlerClass = UtilityConstants.TELEMETRY_CLASS;
            	break;
            default:
                handlerClass = UtilityConstants.CLASS_NOT_FOUND;
                break;
        }
        return handlerClass;
    }
}
