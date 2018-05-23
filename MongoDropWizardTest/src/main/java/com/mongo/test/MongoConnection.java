package com.mongo.test;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoConnection {

	public static Datastore getConnection(String mongoUrl,String dbName) throws UnknownHostException{
		final Morphia morphia = new Morphia();
		morphia.mapPackage("com.test.beans");
		final Datastore datastore = morphia.createDatastore(new MongoClient(new MongoClientURI(mongoUrl)), dbName);		
		datastore.ensureIndexes();
		return datastore;
		
		
	}
}
