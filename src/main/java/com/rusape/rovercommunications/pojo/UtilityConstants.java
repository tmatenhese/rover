package com.rusape.rovercommunications.pojo;

public class UtilityConstants {

	public static final String INITIALISATION_CLASS = "com.rusape.marsrovercommunications.service.impl.IntializationMessageProcessor";
	public static final String TELEMETRY_CLASS = "com.rusape.marsrovercommunications.service.impl.TelemetryMessageProcessor";
	public static final char INITIALIZATION_MESSAGE_TYPE = 'I';
	public static final char TELEMETRY_MESSAGE_TYPE = 'T';
	public static final char BOULDER_MESSAGE_TYPE = 'B';
	public static final char CRATER_MESSAGE_TYPE = 'C';
	public static final char KILLED_MESSAGE_TYPE = 'K';
	public static final char SUCCESS_MESSAGE_TYPE = 'S';
	public static final char END_RUN_MESSAGE_TYPE = 'E';
	public static final String CLASS_NOT_FOUND = "Handler Class Not Found";
}
