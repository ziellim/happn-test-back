package com.happn.testback.business;

import org.junit.Test;

public class GridTest {

    @Test
    public void testAdd(){
        // given
        Grid g = new Grid();
        Point p1 = new Point(-2.3, 38.3);
        Point p2 = new Point(-2.5, 38.3);
        Point p3 = new Point(-2.1, 38.1);
        Area a = new Area(-2.5, 38.0);
        // when
        g.addPoint(p1);
        g.addPoint(p2);
        g.addPoint(p3);
        // then
        assert(g.getAreaByMinLatAndMinLon(-2.5, 38.0).equals(a));
        assert(g.getDenserArea(1).get(0).equals(a));
        assert(g.getAreaByMinLatAndMinLon(0.5, -0.5) == null); // emtpy area
    }

}
