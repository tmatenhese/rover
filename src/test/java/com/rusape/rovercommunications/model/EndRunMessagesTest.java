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
public class EndRunMessagesTest {
	private EndRunMessages endRunMessages;
	@Before
	public void init() {
		endRunMessages = new EndRunMessages();
	}
	
	@Test
	public void testTimeStampSensorMethod() {
		endRunMessages.setTimeStamp(2000l);
		assertEquals(2000,endRunMessages.getTimeStamp(),0.1);
	}
	@Test
	public void testEndrunMethod() {
		endRunMessages.setEndRun('E');
		assertNotNull(endRunMessages.getEndRun());		
	}
	@Test
	public void testScoreMethod() {
		endRunMessages.setScore(2000);
		assertEquals(2000,endRunMessages.getScore());
	}	
}
