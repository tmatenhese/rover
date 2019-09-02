package com.rusape.rovercommunications.service.impl;

import static org.junit.Assert.assertNull;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rusape.rovercommunications.RoverApplication;
import com.rusape.rovercommunications.pojo.RoverCommunicationClient;
@SpringBootTest(classes = RoverApplication.class)
@RunWith(SpringRunner.class)
public class MarsRoverCommunicationsServiceImplTest {
	@Autowired
	private RoverCommunicationClient roverCommunicationClient;
	
	@Test
    public void methodShouldReturnAnIntegerAsPortNumber() throws IllegalAccessException{
		Map<Character,String> resultMap = roverCommunicationClient.startConnection("192.168.1.55", 5656);
        assertNull(resultMap);
    }
}
