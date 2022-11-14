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
              getNumVideosInCategoriesWithNonZeroInventory(videoCollection, categoryCollection);
              getCategoriesForActors(actorCollection, categoryCollection, videoCollection);
              getActorsWithMultipleCategories(actorCollection, categoryCollection, videoCollection);
              getNonComedyActors(actorCollection, categoryCollection, videoCollection);
              getComedyAndActionActors(actorCollection, categoryCollection, videoCollection);
        }
    }

    public static void getNumVideosInCategories(MongoCollection videoCollection, MongoCollection categoryCollection){
        //iterate through categories
        //find num movies by each category id
        FindIterable<Document> iterable = categoryCollection.find();
        try (MongoCursor<Document> cursor = iterable.iterator()) {
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        }
    }

    public static void getNumVideosInCategoriesWithNonZeroInventory(MongoCollection videoCollection, MongoCollection categoryCollection){
        //iterate through categories
        //get videos in category
        //check inventory from last result
        FindIterable<Document> iterable = categoryCollection.find();
        try (MongoCursor<Document> cursor = iterable.iterator()) {
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        }
        
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
