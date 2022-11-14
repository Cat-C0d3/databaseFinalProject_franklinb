package com.mongodb.quickstart;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertManyOptions;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;

public class Create {

    private static final Random rand = new Random();

    public static void main(String[] args) throws FileNotFoundException {
        try (MongoClient mongoClient = MongoClients.create(System.getProperty("mongodb.uri"))) {
            MongoDatabase db = mongoClient.getDatabase("Video");

            db.createCollection("actor");
            db.createCollection("recording");
            db.createCollection("category");

            insertActors(db);
            insertCategories(db);
            insertRecordings(db);
        }
    }

    private static void insertActors(MongoDatabase db) throws FileNotFoundException {
        File actors = new File("src/Video_Actors.txt");
        Scanner in = new Scanner(actors);
        Document doc;
        while(in.hasNextLine()){
            doc = new Document();
            Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(in.nextLine());
            int i = 1;
            while (m.find()){
                switch(i){
                    case 1:
                        doc.append("id", m.group(1).replace(".00", ""));
                        break;
                    case 2:
                        doc.append("name", m.group(1).replace("\"", ""));
                        break;
                    case 3:
                        doc.append("recording_id", m.group(1).replace(".00", ""));
                        break;
                }
                if(i == 3){
                    db.getCollection("actor").insertOne(doc);
                    doc = new Document();
                    i = 1;
                } else {
                    i++;
                }
            }
        }
        in.close();
    }

    private static void insertRecordings(MongoDatabase db) throws FileNotFoundException {
        File recordings = new File("src/Video_Recordings.txt");
        Scanner in = new Scanner(recordings);
        String next;
        while(in.hasNextLine()){
            next = in.nextLine();
            Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(next);
            //10 fields per entry
            int i = 1;
            Document doc = new Document();
            while(m.find()){
                switch (i) {
                    case 1:
                        doc.append("recording_id", m.group(1).replace(".00", ""));
                        break;
                    case 2:
                        doc.append("director", m.group(1).replace("\"", ""));
                        break;
                    case 3:
                        doc.append("title", m.group(1).replace("\"", ""));
                        break;
                    case 4:
                        doc.append("category", m.group(1).replace("\"", ""));
                        break;
                    case 5:
                        doc.append("image_name", m.group(1).replace("\"", ""));
                        break;
                    case 6:
                        doc.append("duration", m.group(1).replace(".00", ""));
                        break;
                    case 7:
                        doc.append("rating", m.group(1).replace("\"", ""));
                        break;
                    case 8:
                        doc.append("year_released", m.group(1).replace(".00", ""));
                        break;
                    case 9:
                        doc.append("price", m.group(1));
                        break;
                    case 10:
                        doc.append("stock_count", m.group(1).replace(".00", ""));
                        break;
                }
                if (i == 10){
                    db.getCollection("recording").insertOne(doc);
                    i = 1;
                    doc = new Document();
                } else {
                    i++;
                }
            }
        }
        in.close();
    }

    private static void insertCategories(MongoDatabase db) throws FileNotFoundException {
        File categories = new File("src/Video_Categories.txt");
        Scanner in = new Scanner(categories);
        Document doc = new Document();

        while (in.hasNextLine()) {
            Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(in.nextLine());
            int i = 0;

            while (m.find()) {
                if (i == 2) {
                    doc.append("name", m.group(1).replace("\"", ""));
                    i = 1;
                    doc = new Document();
                } else {
                    doc.append("category_id", m.group(1).replace(".00", ""));
                    db.getCollection("category").insertOne(doc);
                    i++;
                }
            }
        }
        in.close();
    }
}
