package com.mongodb.quickstart.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class Actor {
    @BsonProperty(value = "id")
    private ObjectId id;
    @BsonProperty(value = "name")
    private String name;
    @BsonProperty(value = "movie_list")
    private ArrayList<String> movieList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<String> movieList) {
        this.movieList = movieList;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
