package com.example.demo;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class IdentityServiceTest {

	@Test
	public void getNameTest() throws Exception {
		RestTemplate rest = mock(RestTemplate.class);
		doReturn("jwt").when(rest).getForObject(eq("http://localhost:7070"), eq(String.class));
		IdentityService identityService = new IdentityService(rest);
		boolean validToken = identityService.checkValidToken("validtoken");
		assertTrue(validToken);
	}

}