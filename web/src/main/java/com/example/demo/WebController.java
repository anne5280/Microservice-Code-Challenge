package com.example.demo;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * @author Ryan Baxter
 */
@RestController
public class WebController {

	private static final Logger LOG = Logger.getLogger(WebController.class.getName());

	private IdentityService identityService;
	private GreetingService greetingService;

	public WebController(IdentityService identityService, GreetingService greetingService) {
		this.identityService = identityService;
		this.greetingService = greetingService;
	}


	// Reporting service query from the front end
	// graphql stitching

	// claims list endpoint
	// REST, accepts manager UUID, header has JWT
	// validate JWT, and extract tenant information
	// validate claim UUID belong to tenant (id service)
	// call dblink (stored proc) with UUID, returns claims_list data

	@RequestMapping
	public String index(HttpServletRequest request) {
		String locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request).toLanguageTag();
		String tenant = request.getParameter("tenant");
		String jwt = request.getParameter("jwt");
		String uuid = request.getParameter("uuid");
		String greeting =  new StringBuilder().append(greetingService.getGreeting(locale)).
				append(" ").append(identityService.checkValidToken(jwt)).toString();
		LOG.info("Greeting: " + greeting);
		LOG.info("Locale: " + locale);
		return greeting;
	}
}
