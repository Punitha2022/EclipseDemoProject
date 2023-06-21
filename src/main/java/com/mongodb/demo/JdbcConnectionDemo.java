package com.mongodb.demo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class JdbcConnectionDemo {

	public static void main(String[] args) {
		MongoClient client=MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database= client.getDatabase("fsd1");
		System.out.println(database.getName());
		for(String name:database.listCollectionNames())
			System.out.println(name);
		System.out.println("Connected successfully..");
	}

}
