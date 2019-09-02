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
public class MartianObjectTest {
	private MartianObject martianObject;
	
	@Before
	public void init() {
		martianObject = new MartianObject();
	}
	@Test
	public void testMartianIdMethod() {
		martianObject.setId(2l);
		assertEquals(2l, martianObject.getId(),0.1f);
	}
	@Test
	public void testMartianDirectionMethod() {
		martianObject.setRadius(2.0f);
		assertEquals(2.0f,martianObject.getRadius(),0.1);
	}
	@Test
	public void testMartianXCoordinateMethod() {
		martianObject.setxCoordinate(2f);
		assertEquals(2f,martianObject.getxCoordinate(),0.1);
	}
	@Test
	public void testMartianYCoordinateMethod() {
		martianObject.setyCoordinate(2f);
		assertEquals(2f,martianObject.getyCoordinate(),0.1);
	}
	@Test
	public void testMartianObjectSpeedMethod() {
		martianObject.setObjectKind("Crater");
		assertEquals("Crater",martianObject.getObjectKind());
	}
	@Test
	public void testMartianObjectTelemetryMethod() {
		TelemetryMessage message = new TelemetryMessage();
		martianObject.setTelemetryMessage(message);
		assertNotNull(martianObject.getTelemetryMessage());		
	}
}
