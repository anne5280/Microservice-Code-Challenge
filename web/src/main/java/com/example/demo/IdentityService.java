package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Ryan Baxter
 */
@Service
public class IdentityService {
	private static final String URL = "http://localhost:7070";
	private RestTemplate rest;

	public IdentityService(RestTemplate rest) {
		this.rest = rest;
	}

	public String checkValidToken(String jwt) {
		return rest.getForObject(new StringBuilder().append(URL).append("/").append(jwt).toString(), String.class);
	}

	public String checkValidTenantUUID(String tenant, String uuid) {

		return rest.getForObject(new StringBuilder().append(URL).append("/").append(tenant).append("/").append(uuid).toString(), String.class);
	}
}
