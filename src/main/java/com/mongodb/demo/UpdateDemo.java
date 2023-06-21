package com.mongodb.demo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class UpdateDemo {
	public static void main(String[] args) {
		System.out.println("In udpateDemo");
		MongoClient client = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = client.getDatabase("trial");
		MongoCollection<Document> collection = database.getCollection("users");
		collection.updateOne(new Document("_firstName", "Ramesh"), 
				new Document("$set",
				new Document("_lastName", "Thilak")));
        MongoCursor<Document> cursor=collection.find().cursor();
        while(cursor.hasNext())
        {
        	Document doc=cursor.next();
        	List user=new ArrayList(doc.values());
        	System.out.printf("%s: %s%n",user.get(1),user.get(2));
        }
        client.close();
	}
}
