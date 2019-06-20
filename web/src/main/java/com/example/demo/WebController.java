package com.example.demo;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

@RestController
public class WebController {

	private static final Logger LOG = Logger.getLogger(WebController.class.getName());

	private IdentityService identityService;
	private ReportingService reportingService;

	public WebController(IdentityService identityService, ReportingService reportingService) {
		this.identityService = identityService;
		this.reportingService = reportingService;
	}


	// Reporting service query from the front end
	// graphql stitching

	// claims list endpoint
	// REST, accepts manager UUID, header has JWT
	// validate JWT, and extract tenant information
	// validate claim UUID belong to tenant (id service)
	// call dblink (stored proc) with UUID, returns claims_list data

	@RequestMapping("/reporting/{jwt}/{tenant}/{uuid}")
	public String index(@PathVariable String jwt, @PathVariable String tenant, @PathVariable String uuid) {

		String claim = "Claim not found.";
		if ( identityService.checkValidToken(jwt) && identityService.checkValidTenantUUID(tenant, uuid)) {
		  claim = new StringBuilder().append(reportingService.executeDblink()).toString();
		}
		LOG.info("Result: " + claim);
		return claim;
	}
}
