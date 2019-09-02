package com.rusape.rovercommunications.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rusape.rovercommunications.RoverApplication;

@SpringBootTest(classes = RoverApplication.class)
@RunWith(SpringRunner.class)
public class EventsMessageTest {
	private EventsMessages eventsMessages;
	
	@Before
	public void init() {
		eventsMessages = new EventsMessages();
	}
	@Test
	public void testEventsMethodIdMethod() {
		eventsMessages.setId(2l);
		assertNotNull(eventsMessages.getId());		
	}
	@Test
	public void testEventsMethodTagMethod() {
		eventsMessages.setMessageTag('E');
		assertEquals('E', eventsMessages.getMessageTag());		
	}
	@Test
	public void testEventsMethodTimestampMethod() {
		eventsMessages.setTimestamp(2.5f);
		assertEquals(2.5f,eventsMessages.getTimestamp(),0.1);		
	}	
}
