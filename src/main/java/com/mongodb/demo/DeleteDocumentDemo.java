package com.mongodb.demo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class DeleteDocumentDemo {
public static void main(String[] args) {
	MongoClient client=MongoClients.create("mongodb://localhost:27017");
	MongoDatabase database=client.getDatabase("trial");
	MongoCollection<Document> collection=database.getCollection("users");
	collection.deleteOne(Filters.eq("_id", 1));
    MongoCursor<Document> cursor=	  collection.find().cursor();
    while(cursor.hasNext()) {
    	Document doc=cursor.next();
    	List user=new ArrayList(doc.values());
    	System.out.printf("%s: %s%n", user.get(1),user.get(2));
    }
    client.close();
}
}
