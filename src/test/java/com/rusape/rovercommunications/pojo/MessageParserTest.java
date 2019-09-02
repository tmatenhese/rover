package com.rusape.rovercommunications.pojo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rusape.rovercommunications.RoverApplication;
import com.rusape.rovercommunications.pojo.MessageParser;

@SpringBootTest(classes = RoverApplication.class)
@RunWith(SpringRunner.class)
public class MessageParserTest {
	@Autowired
	private MessageParser  messageParser; 
	
	@Test
	public void testParsingNullMessageFromRover() {
		Map map = messageParser.responseParser('I', null);
		assertNull(map);
	}
	@Test
	public void testParsingValidInitialisationMessageFromRover() {
		Map map = messageParser.responseParser('I', "I 200.000 200.000 30000 30.000 60.000 20.000 20.0 60.0");		
		assertNotNull(map);
	}	
	@Test
	public void testParsingValidTelemetryMessageFromRover() {
		Map map = messageParser.responseParser('T', "T 3450 aL -234.040 811.100 47.5 8.450");		
		assertNotNull(map);
	}
	@Test
	public void testParsingValidKilledByMartianMessageFromRover() {
		Map map = messageParser.responseParser('K', "K 2002.000");		
		assertNotNull(map);
	}
	@Test
	public void testParsingValidFallInCraterMessageFromRover() {
		Map map = messageParser.responseParser('C', "C 2002.000");		
		assertNotNull(map);
	}
	@Test
	public void testParsingValidHitBoulderMessageFromRover() {
		Map map = messageParser.responseParser('B', "B 2001.000");		
		assertNotNull(map);
	}
	@Test
	public void testParsingValidEndRunMessageFromRover() {
		Map map = messageParser.responseParser('E', "E 2004.000 31000");		
		assertNotNull(map);
	}
	@Test
	public void testParsingValidSuccessMessageFromRover() {
		Map map = messageParser.responseParser('S', "S 2002.000");		
		assertNotNull(map);
	}	
}

