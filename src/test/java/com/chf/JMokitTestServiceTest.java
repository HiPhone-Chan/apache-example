package com.chf;

import mockit.Expectations;

import org.junit.Assert;
import org.junit.Test;

import com.chf.example.other.test.TestService;

/**
 * use jMockit
 * 
 * @author c00251918
 *
 */
public class JMokitTestServiceTest {

	@Test
	public void testJMock() {

		new Expectations(TestService.class) {
			{
				TestService.getValue();
				returns("3");

				TestService.getValue("a");
				returns("1");

				TestService.getValue("b");
				returns("2");
			}
		};
		Assert.assertEquals("3", TestService.getValue());
		Assert.assertEquals("2", TestService.getValue("b"));
		Assert.assertEquals("1", TestService.getValue("a"));
	}
}
