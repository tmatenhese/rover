package com.rusape.rovercommunications.service.impl;

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
public class IntializationMessageProcessorTest {
	private Map<Character,String> responseMap;
	@Autowired
	private MessageParser messageParser;
	@Test
	public void testMethodReturnsAnObjectWhenMessageIsProvided() {
		responseMap = messageParser.responseParser('I', "200.000 200.000 30000 30.000 60.000 20.000 20.0 60.0");
		assertNotNull(responseMap);
	}
	@Test
	public void testMethodReturnsANullMapWhenMessageIsNull() {
		responseMap = messageParser.responseParser('1', null);
		assertNull(responseMap);
	}	
}

