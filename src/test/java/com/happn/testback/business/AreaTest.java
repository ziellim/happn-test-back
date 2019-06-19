package com.happn.testback.business;

import org.junit.jupiter.api.Test;

public class AreaTest {

    @Test
    public void testAdd(){
        // given
        Area a = new Area();
        Point p = new Point(0.1, -0.1);
        // when
        a.addPoint(p);
        // then
        assert(a.density() == 1);
        assert(a.toString().equals("{minLat: 0.0, maxLat: 0.5, minLon: -0.5, maxLon: 0.0}"));
    }
}
