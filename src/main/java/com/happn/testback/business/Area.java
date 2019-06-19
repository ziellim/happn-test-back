package com.happn.testback.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.happn.testback.Util.scale;
import static com.happn.testback.business.Grid.INCREMENT;

public class Area {

    private Double minLat, minLon;
    private List<Point> points;

    public Area() {
        points = new ArrayList<>();
    }

    public Area(Double minLat, Double minLon) {
        this.minLat = minLat;
        this.minLon = minLon;
        points = new ArrayList<>();
    }

    public void addPoint(Point p){
        minLat = scale(p.getLat(), INCREMENT);
        minLon = scale(p.getLon(), INCREMENT);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return minLat.equals(area.minLat) &&
                minLon.equals(area.minLon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minLat, minLon);
    }

    @Override
    public String toString() {
        return "{" +
                "minLat: " + minLat +
                ", maxLat: " + getMaxLat() +
                ", minLon: " + minLon +
                ", maxLon: " + getMaxLon() +
                '}';
    }

}
