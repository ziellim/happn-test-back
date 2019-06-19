package com.happn.testback.business;

public class Point {

    private Double lat, lon;

    public Point(Double lat, Double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "{" +
                "lat: " + lat +
                ", lon: " + lon +
                '}';
    }
}
