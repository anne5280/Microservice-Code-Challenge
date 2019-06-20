package com.example.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

/**
 * @author Ryan Baxter
 */
public class ReportingServiceTest {

	private ReportingService reportingService;

	@Before
	public void setup() {
		RestTemplate rest = mock(RestTemplate.class);
		doReturn("miniClaim").when(rest).getForObject(eq("http://localhost:9090/dblink/789101112"), eq(String.class));
		doReturn("personal auto").when(rest).getForObject(eq("http://localhost:9090/789101112"), eq(String.class));
		reportingService = new ReportingService(rest);
	}

	@After
	public void teardown() {
		reportingService = null;
	}

	@Test
	public void getClaim() throws Exception {
		assertNotNull(reportingService.getClaim("789101112"));
	}

	@Test
	public void executeDBLink() throws Exception {
		assertNotNull(reportingService.executeDblink());
	}

}