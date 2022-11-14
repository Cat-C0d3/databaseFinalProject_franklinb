package com.mongodb.quickstart;

import com.mongodb.client.*;
import com.mongodb.client.model.*;
import com.mongodb.quickstart.models.Category;
import org.bson.BSONObject;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static com.mongodb.client.model.Filters.and;

public class Read {

    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(System.getProperty("mongodb.uri"))) {
            MongoDatabase videoDB = mongoClient.getDatabase("Video");

            MongoCollection<Document> videoCollection = videoDB.getCollection("recording");
            MongoCollection<Document> categoryCollection = videoDB.getCollection("category");
            MongoCollection<Document> actorCollection = videoDB.getCollection("actor");

            getNumVideosInCategories(videoCollection, categoryCollection);
            getNumVideosInCategoriesWithNonZeroInventory(videoCollection, categoryCollection);
//            getCategoriesForActors(actorCollection, categoryCollection, videoCollection);
//            getActorsWithMultipleCategories(actorCollection, categoryCollection, videoCollection);
//            getNonComedyActors(actorCollection, categoryCollection, videoCollection);
//            getComedyAndActionActors(actorCollection, categoryCollection, videoCollection);
        }
    }

    public static void getNumVideosInCategories(MongoCollection videoCollection, MongoCollection categoryCollection) {
        //iterate through categories
        //find num movies by each category id
        FindIterable<Document> categories = categoryCollection.find();
        categories.forEach(x ->{
            Bson filter = Filters.eq("category", x.get("name"));
            getVideosFromCategory(videoCollection, x, filter);
        });
    }
    public static void getNumVideosInCategoriesWithNonZeroInventory(MongoCollection videoCollection, MongoCollection categoryCollection) {
        //iterate through categories
        //get videos in category
        //check inventory from last result
        FindIterable<Document> categories = categoryCollection.find();
        categories.forEach(x ->{
            Bson filter = and(Filters.eq("category", x.get("name")), Filters.nin("stock_count", 0));
            getVideosFromCategory(videoCollection, x, filter);
        });

    }

    private static void getVideosFromCategory(MongoCollection videoCollection, Document x, Bson filter) {
        int numPerCategory = 0;
        FindIterable<Document> videos = videoCollection.find(filter);
        Iterator videoIterator = videos.iterator();
        while (videoIterator.hasNext()){
            numPerCategory++;
        }
        System.out.println(x.get("name") + " " + numPerCategory);
    }

    public static void getCategoriesForActors(MongoCollection actorCollection, MongoCollection categoryCollection, MongoCollection videoCollection) {

    }

    public static void getActorsWithMultipleCategories(MongoCollection actorCollection, MongoCollection categoryCollection, MongoCollection videoCollection) {

    }

    public static void getNonComedyActors(MongoCollection actorCollection, MongoCollection categoryCollection, MongoCollection videoCollection) {

    }

    public static void getComedyAndActionActors(MongoCollection actorCollection, MongoCollection categoryCollection, MongoCollection videoCollection) {

    }
}
