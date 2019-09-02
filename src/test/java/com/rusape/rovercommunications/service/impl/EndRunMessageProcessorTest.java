package com.rusape.rovercommunications.service.impl;

import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.rusape.rovercommunications.RoverApplication;

@SpringBootTest(classes = RoverApplication.class)
@RunWith(SpringRunner.class)
public class EndRunMessageProcessorTest {
	@Autowired
	private EndRunMessageProcessor endRunMessageProcessor;
	@Test
	public void testMethodReturnsAnObjectWhenMessageIsProvided() {
		assertNull(endRunMessageProcessor.processMessage('E', "E 2004.000 31000"));
	}

}
