package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Book {

    String name;
    List<String> review;

    public Book(String name) {
        this.name = name;
        this.review = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getReview() {
        return review;
    }

    public void newReview(String comment){
        review.add(comment);
    }

    public void deleteReview(int id){
        review.remove(id);
    }

    public void changeReview(int id, String comment){
        review.set(id, comment);
    }
}
