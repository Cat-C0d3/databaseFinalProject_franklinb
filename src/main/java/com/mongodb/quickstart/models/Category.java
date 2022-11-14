package com.mongodb.quickstart.models;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class Category {
    @BsonProperty(value="id")
    private int id;
    @BsonProperty(value="name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
