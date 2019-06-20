package com.happn.testback.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.happn.testback.business.Util.scale;
import static com.happn.testback.business.Grid.INCREMENT;

public class GridArea {

    private Double minLat, minLon;
    private List<Point> points;

    public GridArea() {
        points = new ArrayList<>();
    }

    public GridArea(Double minLat, Double minLon) {
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

    public Double getMinLat() {
        return minLat;
    }

    public Double getMinLon() {
        return minLon;
    }

    public Double getMaxLat() {
        return minLat + INCREMENT;
    }

    public Double getMaxLon() {
        return minLon + INCREMENT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridArea gridArea = (GridArea) o;
        return minLat.equals(gridArea.minLat) &&
                minLon.equals(gridArea.minLon);
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
