package com.example.demo;

import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ryan Baxter
 */
@RestController
public class IdentityController {

	private static final Logger LOG = Logger.getLogger(IdentityController.class.getName());

	private IdentityProperties idProperties;

	public IdentityController(IdentityProperties idProperties) {
		this.idProperties = idProperties;
	}

	@RequestMapping
	public String getName() {
		LOG.info("token: " + idProperties.getJwt());
		return idProperties.getJwt();
	}

	@RequestMapping("/{jwt}")
	public String getValidToken() {
		LOG.info("validate: " + idProperties.getJwt());
		return idProperties.getJwt();
	}

	public String getUUID() {
		LOG.info("UUID: " + idProperties.getUuid());
		return idProperties.getUuid();
	}

	public String getTenant() {
		LOG.info("tenant: " + idProperties.getTenant());
		return idProperties.getTenant();
	}

	@RequestMapping("/{tenant}/{uuid}")
	public String getValidUUID() {
		LOG.info("validate Tenant: " + idProperties.getTenant());
		LOG.info("validate UUID: " + idProperties.getUuid());
		return idProperties.getUuid();
	}
}
