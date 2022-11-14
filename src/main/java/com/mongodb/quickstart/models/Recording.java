package com.mongodb.quickstart.models;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class Recording {
    @BsonProperty(value="")
    private int recording_id;
    @BsonProperty(value="")
    private String title;
    @BsonProperty(value="")
    private String director;
    @BsonProperty(value="")
    private String category;
    @BsonProperty(value="")
    private String imageName;
    @BsonProperty(value="")
    private double duration;
    @BsonProperty(value="")
    private String rating;
    @BsonProperty(value="")
    private int year_released;
    @BsonProperty(value="")
    private double price;
    @BsonProperty(value="")
    private int stock_count;

    public int getRecording_id() {
        return recording_id;
    }

    public void setRecording_id(int recording_id) {
        this.recording_id = recording_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getYear_released() {
        return year_released;
    }

    public void setYear_released(int year_released) {
        this.year_released = year_released;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock_count() {
        return stock_count;
    }

    public void setStock_count(int stock_count) {
        this.stock_count = stock_count;
    }
}
