package com.shl.service;

import io.dropwizard.Configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MongoConfiguration extends Configuration {
	@JsonProperty("mongo.nodes")
	private String[] mongoNode;

	@JsonProperty("mongo.port")
	private int mongoPort;

	@JsonProperty("mongo.db")
	private String mongoDb;

	public String[] getMongoNode() {
		return mongoNode;
	}

	public void setMongoNode(String[] mongoNode) {
		this.mongoNode = mongoNode;
	}

	public int getMongoPort() {
		return mongoPort;
	}

	public void setMongoPort(int mongoPort) {
		this.mongoPort = mongoPort;
	}

	public String getMongoDb() {
		return mongoDb;
	}

	public void setMongoDb(String mongoDb) {
		this.mongoDb = mongoDb;
	}

	
}
