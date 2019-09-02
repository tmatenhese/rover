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
public class MartianTest {
	private Martian martian;
	
	@Before
	public void init() {
		martian = new Martian();
	}
	@Test
	public void testMartianIdMethod() {
		martian.setId(2l);
		assertEquals(2l, martian.getId(),0.1f);
	}
	@Test
	public void testMartianDirectionMethod() {
		martian.setDirection(2.0f);
		assertEquals(2.0f,martian.getDirection(),0.1);
	}
	@Test
	public void testMartianXCoordinateMethod() {
		martian.setxCoordinate(2f);
		assertEquals(2f,martian.getxCoordinate(),0.1);
	}
	@Test
	public void testMartianYCoordinateMethod() {
		martian.setyCoordinate(2f);
		assertEquals(2f,martian.getyCoordinate(),0.1);
	}
	@Test
	public void testMartianSpeedMethod() {
		martian.setSpeed(2f);
		assertEquals(2f,martian.getSpeed(),0.1);
	}
	@Test
	public void testMartianTelemetryMethod() {
		TelemetryMessage message = new TelemetryMessage();
		martian.setTelemetryMessage(message);
		assertNotNull(martian.getTelemetryMessage());		
	}
}
