package com.ruizpatricio.oscar.filters;

/**
 * Created by Oscar on 27/06/2017.
 */

public class Serie {

    private String name;
    private int year;
    private String genre;
    private boolean seen;

    public Serie(String name, int year, String genre) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        seen = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }
}
