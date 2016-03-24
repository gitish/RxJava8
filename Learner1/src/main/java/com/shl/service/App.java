package com.shl.service;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shl.resource.RewardsResource;

/**
 * This is an example of dropwizard with mongoDb
 * @author sshail
 *
 */
public class App extends Application<MongoConfiguration> {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	@Override
	public void initialize(Bootstrap<MongoConfiguration> b) {
	}

	@Override
	public void run(MongoConfiguration c, Environment e)
			throws Exception {
		LOGGER.info("Method App#run() called");
		System.out.println("Hello world, by Dropwizard!");
		System.out.println("Mongo host : " + c.getMongoNode()[0]);
		System.out.println("Mongo port : " + c.getMongoPort());
		System.out.println("Mongo DB : " + c.getMongoDb());
		e.jersey().register(new RewardsResource(c));
	}

	public static void main(String[] args) throws Exception {
		new App().run(args);
	}
}