package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Ryan Baxter
 */
@Service
public class ReportingService {
	private static final String URL = "http://localhost:9090";
	private RestTemplate rest;

	public ReportingService(RestTemplate rest) {
		this.rest = rest;
	}

	public String getClaim(String claimid) {
		return rest.getForObject(new StringBuilder().append(URL).append("/").append(claimid).toString(), String.class);
	}

	public String executeDblink() {
		return rest.getForObject(new StringBuilder().append(URL).append("/dblink/789101112").toString(), String.class);
	}
}
