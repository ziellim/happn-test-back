package com.happn.testback.business;

import org.junit.Test;

public class GridAreaTest {

    @Test
    public void testAdd(){
        // given
        GridArea a = new GridArea();
        Point p = new Point(0.1, -0.1);
        // when
        a.addPoint(p);
        // then
        assert(a.density() == 1);
        assert(a.toString().equals("{minLat: 0.0, maxLat: 0.5, minLon: -0.5, maxLon: 0.0}"));
    }
}
