package com.happn.testback.business;

import java.util.ArrayList;
import java.util.List;

import static com.happn.testback.business.Grid.INCREMENT;

public class Area {

    private Double minLat, minLon;
    private List<Point> points;

    public Area() {
        points = new ArrayList<>();
    }

    public void addPoint(Point p){
        minLat = scale(p.getLat());
        minLon = scale(p.getLon());
        points.add(p);
    }

    public int density(){
        return points.size();
    }

    private Double getMaxLat() {
        return minLat + INCREMENT;
    }

    private Double getMaxLon() {
        return minLon + INCREMENT;
    }

    private Double scale(Double value){
        return Math.floor(value / INCREMENT) * INCREMENT;
    }

    @Override
    public String toString() {
        return "{" +
                "minLat: " + minLat +
                ", maxLat:" + getMaxLat() +
                ", minLon:" + minLon +
                ", maxLon:" + getMaxLon() +
                '}';
    }

}
