package com.rusape.rovercommunications.pojo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.rusape.rovercommunications.RoverApplication;
@SpringBootTest(classes = RoverApplication.class)
@RunWith(SpringRunner.class)
public class TelemetryMessageParserTest {
	@Autowired
	private TelemetryMessageParser  messageParser; 
	
	@Test
	public void testTelemetryMapMethod() {
		Map<Character, String> telemetryMap = new HashMap<Character, String>();
		messageParser.setTelemetryMap(telemetryMap);
		assertNotNull(messageParser.getTelemetryMap());
	}
	@Test
	public void testParsingValidInitialisationMessageFromRover() {
		Map map = messageParser.getMessageMap("T 3450 aL -234.040 811.100 47.5 8.450 b -220.000 750.000 12.000 m -240.000 812.000 90.0 9.100 b -220.000 750.000 12.000 c -220.000 750.000 12.000");		
		assertNotNull(map);
	}	

}
