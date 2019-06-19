package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Ryan Baxter
 */
@ConfigurationProperties
public class IdentityProperties {

	private String uuid;
	private String jwt;
	private String tenant;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
