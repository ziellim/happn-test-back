package com.happn.testback.business;

public class Grid {

    private static final Double INCREMENT = 0.5;
    private static final int X = 180;
    private static final int Y = 360;

    private Area[][] map;

    public Grid(){
        map = new Area[X * 2][Y * 2];
    }

    public void addPoint(Double lat, Double lon){
        int x = X + scale(lat);
        System.out.println(x);
        int y = Y - scale(lon);
        System.out.println(y);

        Area a = map[x][y];
        if(a == null){
            a = new Area();
        }
        a.addPoint(new Point(lat, lon));

        map[x][y] = a;
    }

    public Area getAreaByMaxLatAndMinLon(Double maxLat, Double minLon){
        return map[X + scale(maxLat)][Y - scale(minLon)];
    }

    private int scale(Double value){
        Double rounded = (value <= 0 ? Math.floor(value) : Math.ceil(value)) / INCREMENT;
        return rounded.intValue();
    }
}
