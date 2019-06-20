package com.happn.testback;

import com.google.common.io.Resources;
import com.happn.testback.business.PointsLoader;
import com.happn.testback.business.Grid;
import com.happn.testback.business.Point;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class HappnTestBack {

    private Grid g;

    @Test
    public void testBack(){
        g = new Grid();
        System.out.println("create grid");
        try {
            List<Point> points = new PointsLoader(Resources.getResource("points.tsv").getPath()).readPoints();
            points.forEach(point -> addPoint(point.getLat(), point.getLon()));
            System.out.println("density of {minlat: 6.5, minlon: -7} area: " + g.getAreaByMinLatAndMinLon(6.5, -7.0).density()); // 2
            System.out.println("the two densest areas: " + g.getDenserArea(2)); // [ {"minLat":-2.5, "maxLat":-2, "minLon":38, "maxLon":38.5}, {"minLat":6.5, "maxLat":7, "minLon":-7, "maxLon":-6.5}]
        } catch (IOException e) {
            e.getMessage();
            System.exit(-1);
        }
    }

    private void addPoint(Double lat, Double lon){
        Point p = new Point(lat, lon);
        g.addPoint(p);
        System.out.println("add point: " + p);
    }
}
