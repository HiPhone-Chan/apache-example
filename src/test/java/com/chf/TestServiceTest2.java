package com.chf;

import mockit.Expectations;
import mockit.integration.junit4.JMockit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.chf.example.other.test.TestService;

/**
 * use jMockit
 * 
 * @author c00251918
 *
 */
@RunWith(JMockit.class)
public class TestServiceTest2 {

	@Test
	public void testJMock() {

		new Expectations(TestService.class) {
			{
				TestService.getValue();
				returns("3");
			}
		};
		Assert.assertEquals("3", TestService.getValue());
	}
}
