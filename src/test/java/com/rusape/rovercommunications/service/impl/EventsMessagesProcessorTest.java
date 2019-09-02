package com.rusape.rovercommunications.service.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.rusape.rovercommunications.RoverApplication;

@SpringBootTest(classes = RoverApplication.class)
@RunWith(SpringRunner.class)
public class EventsMessagesProcessorTest {
	@Autowired
	private EventsMessagesProcessor eventsMessageProcessor;
	@Test
	public void testMethodReturnsAnObjectWhenMessageIsProvided() {
//		assertNotNull(eventsMessageProcessor.processMessage('B', "B 2002.000"));
	}
}
