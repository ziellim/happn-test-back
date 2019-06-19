package com.happn.testback;

import com.happn.testback.business.Grid;
import com.happn.testback.business.Point;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

    private Grid g;

    @Test
    public void run(){
        g = new Grid();
        System.out.println("create grid");
        addPoint(-48.6, -37.7);
        addPoint(-27.1, 8.4);
        addPoint(6.6, -6.9);
        addPoint(-2.3, 38.3);
        addPoint(6.8, -6.9);
        addPoint(-2.5, 38.3);
        addPoint(0.1, -0.1);
        addPoint(-2.1, 38.1);
        System.out.println("density of {minlat: 6.5, minlon: -7} area: " + g.getAreaByMinLatAndMinLon(6.5, -7.0).density()); // 2
        System.out.println("the two densest areas: " + g.getDenserArea(2)); // [ {"minLat":-2.5, "maxLat":-2, "minLon":38, "maxLon":38.5}, {"minLat":6.5, "maxLat":7, "minLon":-7, "maxLon":-6.5}]
    }

    private void addPoint(Double lat, Double lon){
        Point p = new Point(lat, lon);
        g.addPoint(p);
        System.out.println("add point: " + p);
    }
}
