package com.rusape.rovercommunications.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rusape.rovercommunications.RoverApplication;

@SpringBootTest(classes = RoverApplication.class)
@RunWith(SpringRunner.class)
public class TelemetryMessageTest {
	private TelemetryMessage telemetryMessage;
	@Before
	public void init() {
		telemetryMessage = new TelemetryMessage();
	}
	@Test
	public void testInitIdMethod() {
		telemetryMessage.setId(2l);
		assertEquals(2l, telemetryMessage.getId(),0.1f);
	}
	@Test
	public void testYCoordinateMethod() {
		telemetryMessage.setVehicleYCoordinate(2f);
		assertEquals(2f,telemetryMessage.getVehicleYCoordinate(),0.1);
	}
	@Test
	public void testXCoordinateMethod() {
		telemetryMessage.setVehicleXCoordinate(2f);
		assertEquals(2f,telemetryMessage.getVehicleXCoordinate(),0.1);
	}
	@Test
	public void testControlMessageMethod() {
		telemetryMessage.setControlMessage("al");
		assertEquals("al",telemetryMessage.getControlMessage());
	}
	@Test
	public void testVehicleControlMethod() {
		telemetryMessage.setVehicleControl("al");
		assertEquals("al",telemetryMessage.getVehicleControl());
	}
	@Test
	public void testMartianObjectMethod() {
		List<MartianObject> martians = new ArrayList<MartianObject>();
		telemetryMessage.setMartianObject(martians);
		assertNotNull(telemetryMessage.getMartianObject());
	}
	@Test
	public void testMartiansMethod() {
		List<Martian> martians = new ArrayList<Martian>();
		telemetryMessage.setMartians(martians);
		assertNotNull(telemetryMessage.getMartians());
	}
	@Test
	public void testDirectionMethod() {
		telemetryMessage.setVehicleDirection(2.0f);
		assertEquals(2.0f,telemetryMessage.getVehicleDirection(),0.1);
	}	
	@Test
	public void testInitTimeStampSensorMethod() {
		telemetryMessage.setTimeStamp(2000);
		assertEquals(2000,telemetryMessage.getTimeStamp());
	}
	
}
