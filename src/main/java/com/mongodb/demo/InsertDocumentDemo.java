package com.mongodb.demo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoCommandException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InsertDocumentDemo {

	public static void main(String[] args) {
		try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

            MongoDatabase database = mongoClient.getDatabase("trial");

            try {
                database.createCollection("users");
                System.out.println("Collection created successfully");
            } catch (MongoCommandException e) {
                database.getCollection("users").drop();
            }

            List<Document> docs = new ArrayList< Document > ();

            MongoCollection < Document > collection = database.getCollection("users");

            Document d1 = new Document("_id", 1);
            d1.append("_firstName", "Ramesh");
            d1.append("_lastName", "Fadatare");
            docs.add(d1);

            Document d2 = new Document("_id", 2);
            d2.append("_firstName", "Tony");
            d2.append("_lastName", "Stark");
            docs.add(d2);

            Document d3 = new Document("_id", 3);
            d3.append("_firstName", "Tom");
            d3.append("_lastName", "Cruise");
            docs.add(d3);

            Document d4 = new Document("_id", 4);
            d4.append("_firstName", "Amir");
            d4.append("_lastName", "Khan");
            docs.add(d4);

            Document d5 = new Document("_id", 5);
            d5.append("_firstName", "Umesh");
            d5.append("_lastName", "Fadatare");
            docs.add(d5);

            collection.insertMany(docs);
        }
    }
	}


