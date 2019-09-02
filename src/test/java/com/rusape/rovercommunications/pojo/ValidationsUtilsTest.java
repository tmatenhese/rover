package com.rusape.rovercommunications.pojo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rusape.rovercommunications.RoverApplication;
import com.rusape.rovercommunications.pojo.ValidationsUtils;

@SpringBootTest(classes = RoverApplication.class)
@RunWith(SpringRunner.class)
public class ValidationsUtilsTest {
	@Autowired
	private ValidationsUtils validationsUtils;

	@Test
    public void methodShouldReturnAnIntegerAsPortNumber() throws IllegalAccessException{
    	int port = validationsUtils.validateIPandPort("192.168.1.10","5656");
        assertNotNull(port);
    }
	
	@Test(expected=IllegalAccessException.class)
	public void throwIllegalArgumentExceptionWhenPortIsNotAnInteger() throws IllegalAccessException {
		validationsUtils.validateIPandPort("192.168.1.10","test");
	}
	
	@Test
	public void checkIfThePortHas4Digits(){
		assertTrue(validationsUtils.validatePortLength(5656));
	}	
	@Test
	public void checkIfThePortWithout4Digits(){
		assertFalse(validationsUtils.validatePortLength(56561));
	}
}
