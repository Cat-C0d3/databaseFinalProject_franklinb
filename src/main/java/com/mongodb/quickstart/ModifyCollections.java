package com.mongodb.quickstart;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class ModifyCollections {
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(System.getProperty("mongodb.uri"))) {
            MongoDatabase videoDB = mongoClient.getDatabase("video");
            MongoCollection<Document> videoCollection = videoDB.getCollection("recording");
            MongoCollection<Document> categoryCollection = videoDB.getCollection("category");
            MongoCollection<Document> actorCollection = videoDB.getCollection("actor");


//            videoDB.createCollection("actor");
//            videoDB.createCollection("movie");
//            videoDB.createCollection("inventory");
//            videoDB.createCollection("category");

            createMovieCollection();
            createInventoryCollection();
        }
    }

    private static void createMovieCollection(){

    }

    private static void createInventoryCollection(){

    }
}
