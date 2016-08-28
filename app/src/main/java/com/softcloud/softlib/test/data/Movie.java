package com.softcloud.softlib.test.data;

import java.util.List;

/**
 * Created by Softcloud on 16/8/28.
 */
public class Movie extends BaseData {
    private String id;
    private String title;
    private String year;
    private List<String> genres;
    private Image images;
    private String alt;
    private Rate rating;
    private List<Person> casts;
    private List<Person> directors;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public List<String> getGenres() {
        return genres;
    }

    public Image getImages() {
        return images;
    }

    public String getAlt() {
        return alt;
    }

    public Rate getRating() {
        return rating;
    }

    public List<Person> getCasts() {
        return casts;
    }

    public List<Person> getDirectors() {
        return directors;
    }
}
