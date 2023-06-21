package com.mongodb.demo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class FindDemo {

	public static void main(String[] args) {
		MongoClient client=MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database=  client.getDatabase("trial");
	  MongoCollection<Document> collection=	database.getCollection("users");
	  MongoCursor<Document> cursor=  collection.find().iterator();
	  while(cursor.hasNext())
	  {
		  Document doc=cursor.next();
		  List users=new ArrayList<>(doc.values());
		  System.out.printf("%s: %s%n",users.get(1),users.get(2));
		  
	  }
	  
	  client.close();
	}

}
