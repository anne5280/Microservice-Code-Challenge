package com.example.demo;

import java.util.logging.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportingController {
	private static final Logger LOG = Logger.getLogger(ReportingController.class.getName());

	private ReportingProperties ReportingProperties;

	public ReportingController(ReportingProperties ReportingProperties) {
		this.ReportingProperties = ReportingProperties;
	}

	@RequestMapping("/dblink/{claimid}")
	public String executeDBLink(@PathVariable String claimid){
		LOG.info("Claimid: " + claimid);
		LOG.info("Executing dblink: " + ReportingProperties.getDblink());

		return ReportingProperties.getClaim().equalsIgnoreCase(claimid) ? "DBLink executed, claim found: "+claimid : "DBLink executed, claim NOT found.";
	}

	@RequestMapping("/dblink")
	public String executeDBLink(){
		LOG.info("Database call: " + ReportingProperties.getDblink());

		return ReportingProperties.getDblink();
	}

	@RequestMapping("/{claimid}")
	public String getClaim(@PathVariable String claimid){
		LOG.info("Lookup Claimid: " + claimid);

		return ReportingProperties.getClaim().equalsIgnoreCase(claimid) ? "Claim lookup, claim found." : "Claim lookup, claim NOT found.";
	}
}
