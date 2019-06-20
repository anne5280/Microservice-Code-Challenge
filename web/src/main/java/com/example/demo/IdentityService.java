package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IdentityService {
	private static final String URL = "http://localhost:7070";
	private RestTemplate rest;

	public IdentityService(RestTemplate rest) {
		this.rest = rest;
	}

	public boolean checkValidToken(String jwt) {
		String token = rest.getForObject(new StringBuilder().append(URL).append("/").append(jwt).toString(), String.class);
		return token.isEmpty() ? false : true;
	}

	public boolean checkValidTenantUUID(String tenant, String uuid) {
		String matchUuid = rest.getForObject(new StringBuilder().append(URL).append("/").append(tenant).append("/").append(uuid).toString(), String.class);

		return !matchUuid.isEmpty();
	}
}
