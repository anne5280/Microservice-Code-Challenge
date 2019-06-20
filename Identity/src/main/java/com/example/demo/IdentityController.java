package com.example.demo;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IdentityController {

	private static final Logger LOG = Logger.getLogger(IdentityController.class.getName());

	private IdentityProperties idProperties;
	private HttpServletRequest request;

	public IdentityController(IdentityProperties idProperties) {
		this.idProperties = idProperties;
	}

	@RequestMapping("/{jwt}")
	public String getValidToken(@PathVariable String jwt) {
		LOG.info("validate: " + jwt + " and " + idProperties.getJwt());
		return idProperties.getJwt().equalsIgnoreCase(jwt)  ? "Valid "+ jwt : "Try again, invalid JWT";
	}

	public boolean isValidJWT(String jwt) {
			LOG.info("validate: " + jwt + " and " + idProperties.getJwt());
			return idProperties.getJwt().equalsIgnoreCase(jwt)  ? true : false;
	}

	public boolean isValidUUID(@PathVariable String tenant, @PathVariable String uuid) {

		return (idProperties.getTenant().equalsIgnoreCase(tenant) && idProperties.getUuid().equalsIgnoreCase(uuid)) ?
				true : false;
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
	public String getValidUUID(@PathVariable String tenant, @PathVariable String uuid) {

		LOG.info("validate Tenant: " + tenant+ " and " + idProperties.getTenant());
		LOG.info("validate UUID: " + uuid+ " and " + idProperties.getUuid());

		return (idProperties.getTenant().equalsIgnoreCase(tenant) && idProperties.getUuid().equalsIgnoreCase(uuid)) ?
				"Found "+ uuid : "Try again, invalid tenant and/or UUID";
	}
}
