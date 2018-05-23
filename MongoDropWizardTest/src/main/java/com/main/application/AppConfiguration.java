package com.main.application;

import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class AppConfiguration extends Configuration{
	
	@NotEmpty
	private final String appName = null;

	@NotEmpty
	private final String mongodbUrl = null;
	
	@NotEmpty
	private final String mongodbName =null;
	
	@JsonProperty
	public String getAppName() {
		return appName;
	}
	
	@JsonProperty
	public String getMongodbUrl() {
		return mongodbUrl;
	}

	@JsonProperty
	public String getMongodbName() {
		return mongodbName;
	}
	


	
	
}
