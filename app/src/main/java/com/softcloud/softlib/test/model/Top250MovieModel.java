package com.softcloud.softlib.test.model;

import com.softcloud.softlib.test.data.Movie;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Softcloud on 16/8/28.
 */
public class Top250MovieModel extends BaseModel {
    private int start;
    private int count;
    private int total;
    private String title;
    private List<Movie> subjects;

    public int getStart() {
        return start;
    }

    public int getCount() {
        return count;
    }

    public int getTotal() {
        return total;
    }

    public String getTitle() {
        return title != null ? title : "--";
    }

    public List<Movie> getSubjects() {
        return subjects != null ? subjects : Collections.<Movie>emptyList();
    }
}
