package com.chf;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.chf.example.other.test.MockDao;
import com.chf.example.other.test.TestService;

/**
 * use jMock
 * @author c00251918
 *
 */
public class JmockTestServiceTest {

	@Test
	@Ignore
	public void test() {
		Mockery context = new JUnit4Mockery();

		MockDao dao = context.mock(MockDao.class);

		context.checking(new Expectations() {
			{
				oneOf(dao).getValue(1);
				will(returnValue("hi"));
			}
		});

		Assert.assertEquals("hi", TestService.test(dao));
	}
	
}
