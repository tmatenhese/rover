package com.rusape.rovercommunications.pojo;

import static org.junit.Assert.assertNull;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rusape.rovercommunications.RoverApplication;

@SpringBootTest(classes = RoverApplication.class)
@RunWith(SpringRunner.class)
public class RoverCommunicationClientTest {
	private Map<Character,String> resultMap;
	@Autowired
	private RoverCommunicationClient roverCommunicationClient;
	
    @Test
    public void connectToServerAndGetMessagesWhenIPandPortAreValid() {
    	resultMap = roverCommunicationClient.startConnection("192.168.11.55", 5656); 
         assertNull(resultMap);
     } 

}

