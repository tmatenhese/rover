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
public class InitialisationMessageTest {
	private InitializationMessage initializationMessage;
	@Before
	public void init() {
		initializationMessage = new InitializationMessage();
	}
	@Test
	public void testInitIdMethod() {
		initializationMessage.setId(2l);
		assertEquals(2l, initializationMessage.getId(),0.1f);
	}
	@Test
	public void testInitXCoordinateMethod() {
		initializationMessage.setxCoordinate(2f);
		assertEquals(2f,initializationMessage.getxCoordinate(),0.1);
	}
	@Test
	public void testInitYCoordinateMethod() {
		initializationMessage.setyCoordinate(2f);
		assertEquals(2f,initializationMessage.getyCoordinate(),0.1);
	}
	@Test
	public void testInitObjectMaximumSpeedMethod() {
		initializationMessage.setMaximumSpeed(2.0f);
		assertEquals(2.0f,initializationMessage.getMaximumSpeed(),0.1);
	}
	@Test
	public void testInitHardTurnMethod() {
		initializationMessage.setMaximumHardTurn(2.0f);
		assertEquals(2.0f,initializationMessage.getMaximumHardTurn(),0.1);
	}
	@Test
	public void testInitSenorMethod() {
		initializationMessage.setMaximumSensorRange(2.0f);
		assertEquals(2.0f,initializationMessage.getMaximumSensorRange(),0.1);
	}
	@Test
	public void testInitTurnMethod() {
		initializationMessage.setMaximumTurn(2.0f);
		assertEquals(2.0f,initializationMessage.getMaximumTurn(),0.1);
	}
	@Test
	public void testInitMinSensorMethod() {
		initializationMessage.setMinimumSensorRange(2.0f);
		assertEquals(2.0f,initializationMessage.getMinimumSensorRange(),0.1);
	}	
	@Test
	public void testInitTimelimitSensorMethod() {
		initializationMessage.setTimeLimit(2000l);
		assertEquals(2000,initializationMessage.getTimeLimit());
	}	
}
