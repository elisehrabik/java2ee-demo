package edu.kirkwood.emeraldTrails.model;

import java.time.LocalTime;

public class Trail {
    String trailName;
    double trailDistance;
    TrailDifficulty trailDifficulty;
    LocalTime trailTime;
    String trailDescription;
    Boolean allowsBikes;
    String trailImage;

    public Trail(String trailName, double trailDistance, TrailDifficulty trailDifficulty, LocalTime trailTime, String trailDescription, Boolean allowsBikes, String trailImage) {
        this.trailName = trailName;
        this.trailDistance = trailDistance;
        this.trailDifficulty = trailDifficulty;
        this.trailTime = trailTime;
        this.trailDescription = trailDescription;
        this.allowsBikes = allowsBikes;
        this.trailImage = trailImage;
    }

    public String getTrailName() {
        return trailName;
    }

    public void setTrailName(String trailName) {
        this.trailName = trailName;
    }

    public double getTrailDistance() {
        return trailDistance;
    }

    public void setTrailDistance(double trailDistance) {
        this.trailDistance = trailDistance;
    }

    public TrailDifficulty getTrailDifficulty() {
        return trailDifficulty;
    }

    public void setTrailDifficulty(TrailDifficulty trailDifficulty) {
        this.trailDifficulty = trailDifficulty;
    }

    public LocalTime getTrailTime() {
        return trailTime;
    }

    public void setTrailTime(LocalTime trailTime) {
        this.trailTime = trailTime;
    }

    public String getTrailDescription() {
        return trailDescription;
    }

    public void setTrailDescription(String trailDescription) {
        this.trailDescription = trailDescription;
    }

    public Boolean getAllowsBikes() {
        return allowsBikes;
    }

    public void setAllowsBikes(Boolean allowsBikes) {
        this.allowsBikes = allowsBikes;
    }

    public String getTrailImage() {
        return trailImage;
    }

    public void setTrailImage(String trailImage) {
        this.trailImage = trailImage;
    }

    @Override
    public String toString() {
        return "Trail{" +
                "trailName='" + trailName + '\'' +
                ", trailDistance=" + trailDistance +
                ", trailDifficulty=" + trailDifficulty +
                ", trailTime=" + trailTime +
                ", trailDescription='" + trailDescription + '\'' +
                ", allowsBikes=" + allowsBikes +
                ", trailImage='" + trailImage + '\'' +
                '}';
    }
}
