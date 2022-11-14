package com.mongodb.quickstart;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.descending;

public class Read {

    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(System.getProperty("mongodb.uri"))) {
            MongoDatabase sampleTrainingDB = mongoClient.getDatabase("Video");

            MongoCollection<Document> videoCollection = sampleTrainingDB.getCollection("video");
            MongoCollection<Document> categoryCollection = sampleTrainingDB.getCollection("category");
            MongoCollection<Document> actorCollection = sampleTrainingDB.getCollection("actor");

            getNumVideosInCategories(videoCollection, categoryCollection);
            getNumVideosInCategoriesWithNonZeroInventory(videoCollection);
            getCategoriesForActors(actorCollection, categoryCollection, videoCollection);
            getActorsWithMultipleCategories(actorCollection, categoryCollection, videoCollection);
            getNonComedyActors(actorCollection, categoryCollection, videoCollection);
            getComedyAndActionActors(actorCollection, categoryCollection, videoCollection);
        }
    }

    public static void getNumVideosInCategories(MongoCollection videoCollection, MongoCollection categoryCollection){

    }

    public static void getNumVideosInCategoriesWithNonZeroInventory(MongoCollection videoCollection){

    }

    public static void getCategoriesForActors(MongoCollection actorCollection, MongoCollection categoryCollection, MongoCollection videoCollection){

    }

    public static void getActorsWithMultipleCategories(MongoCollection actorCollection, MongoCollection categoryCollection, MongoCollection videoCollection){

    }

    public static void getNonComedyActors(MongoCollection actorCollection, MongoCollection categoryCollection, MongoCollection videoCollection){

    }

    public static void getComedyAndActionActors(MongoCollection actorCollection, MongoCollection categoryCollection, MongoCollection videoCollection){

    }
}
