package edu.kirkwood.emeraldTrails.model;

import java.time.LocalTime;

public class Trail {
    int trail_id;
    String trail_name;
    double trail_distance;
    TrailDifficulty trail_difficulty;
    LocalTime trail_time;
    String trail_description;
    Boolean allows_bikes;
    String trail_image;

    public Trail(int trail_id, String trail_name, double trail_distance, TrailDifficulty trail_difficulty, LocalTime trail_time, String trail_description, Boolean allows_bikes, String trail_image) {
        this.trail_id = trail_id;
        this.trail_name = trail_name;
        this.trail_distance = trail_distance;
        this.trail_difficulty = trail_difficulty;
        this.trail_time = trail_time;
        this.trail_description = trail_description;
        this.allows_bikes = allows_bikes;
        this.trail_image = trail_image;
    }

    public Trail(){

    };

    public String getTrail_name() {
        return trail_name;
    }

    public void setTrail_name(String trail_name) {
        this.trail_name = trail_name;
    }

    public double getTrail_distance() {
        return trail_distance;
    }

    public void setTrail_distance(double trail_distance) {
        this.trail_distance = trail_distance;
    }

    public TrailDifficulty getTrail_difficulty() {
        return trail_difficulty;
    }

    public void setTrail_difficulty(TrailDifficulty trail_difficulty) {
        this.trail_difficulty = trail_difficulty;
    }

    public LocalTime getTrail_time() {
        return trail_time;
    }

    public void setTrail_time(LocalTime trail_time) {
        this.trail_time = trail_time;
    }

    public String getTrail_description() {
        return trail_description;
    }

    public void setTrail_description(String trail_description) {
        this.trail_description = trail_description;
    }

    public Boolean getAllows_bikes() {
        return allows_bikes;
    }

    public void setAllows_bikes(Boolean allows_bikes) {
        this.allows_bikes = allows_bikes;
    }

    public String getTrail_image() {
        return trail_image;
    }

    public void setTrail_image(String trail_image) {
        this.trail_image = trail_image;
    }

    public int getTrail_id() {
        return trail_id;
    }

    public void setTrail_id(int trail_id) {
        this.trail_id = trail_id;
    }

    @Override
    public String toString() {
        return "Trail{" +
                "trail_id=" + trail_id +
                ", trail_name='" + trail_name + '\'' +
                ", trail_distance=" + trail_distance +
                ", trail_difficulty=" + trail_difficulty +
                ", trail_time=" + trail_time +
                ", trail_description='" + trail_description + '\'' +
                ", allows_bikes=" + allows_bikes +
                ", trail_image='" + trail_image + '\'' +
                '}';
    }
}
