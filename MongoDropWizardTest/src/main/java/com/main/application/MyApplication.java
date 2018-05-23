package com.main.application;


import com.mongo.test.MongoConnection;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MyApplication extends Application<AppConfiguration> {

	
	public  static void main(String[] args) throws Exception {
			new MyApplication().run(args);
	}

	@Override
	public void run(AppConfiguration configuration, Environment environment)
			throws Exception {
		System.out.println(configuration.getAppName());
		environment.jersey().register(new RestController(MongoConnection.getConnection(configuration.getMongodbUrl(),configuration.getMongodbName())));
		
	}

	@Override
	public void initialize(Bootstrap<AppConfiguration> bootstrap) {
		// TODO Auto-generated method stub
		
	}

	
}
