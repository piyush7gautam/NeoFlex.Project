package com.neoflex.model;

public class Movie {
    private String title;
    private String genre;
    private double rating;
    private String imageUrl;

    // Default constructor
    public Movie() {}

    // Constructor with all fields
    public Movie(String title, String genre, double rating, String imageUrl) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title != null ? title.trim() : null;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre != null ? genre.trim() : null;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        // Keep ratings between 0 and 10
        if (rating < 0) rating = 0;
        if (rating > 10) rating = 10;
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl != null ? imageUrl.trim() : null;
    }
}



