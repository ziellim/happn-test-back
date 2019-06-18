package com.happn.testback;

import com.happn.testback.business.Grid;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

    @Test
    public void run(){
        Grid g = new Grid();
        g.addPoint(-48.6, -37.7);
        g.addPoint(-27.1, 8.4);
        g.addPoint(6.6, -6.9);
        g.addPoint(-2.3, 38.3);
        g.addPoint(6.8, -6.9);
        g.addPoint(-2.5, 38.3);
        g.addPoint(0.1, -0.1);
        g.addPoint(-2.1, 38.1);
        System.out.println(g.getAreaByMaxLatAndMinLon(7.0, -7.0).density()); // 2
        System.out.println(g.getDenserArea(2)); // [ {"minLat":-2.5, "maxLat":-2, "minLon":38, "maxLon":38.5}, {"minLat":6.5, "maxLat":7, "minLon":-7, "maxLon":-6.5}]
    }
}
