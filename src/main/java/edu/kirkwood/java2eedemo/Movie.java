package edu.kirkwood.java2eedemo;


import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;


public class Movie implements Comparable<Movie> {
    public String title;
    public String overview;
    public LocalDate release_date;
    public String poster_path;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    @Override
    public int compareTo(@NotNull Movie o) {
        return 0;
    }

    /*
    @Override
    public int compareTo(@NotNull Movie o) {
        int result = Double.compare(this.vote_average, o.vote_average) * -1;
        if (result == 0) {
            result = this.title.compareTo(o.title);
        }
        return result;
    }
    */

}
