package com.happn.testback.business;

import java.util.ArrayList;
import java.util.List;

public class Area {

    private List<Point> points;

    public Area() {
        points = new ArrayList<>();
    }

    public void addPoint(Point p){
        points.add(p);
    }

    public int density(){
        return points.size();
    }

}
