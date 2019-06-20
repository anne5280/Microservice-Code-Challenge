package com.example.demo;

import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("claim")
public class ReportingProperties {

	private String dblink;
	private String claimid;
	private String applied_insurance_line;

	public void setClaimid(java.lang.String claimid) {
		this.claimid = claimid;
	}

	public String getClaim() {
		return claimid;
	}

	public void setDblink(String dblink) {
		this.dblink = dblink;
	}

	public String getDblink() { return dblink; }

	public void setClaim(String applied_insurance_line) {
		this.applied_insurance_line = applied_insurance_line;
	}

	public String getOrDefault() {
		return (applied_insurance_line == null || applied_insurance_line.isEmpty()) ? "Claim  not found." : applied_insurance_line;
	}
}
