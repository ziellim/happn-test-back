package com.happn.testback.business;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Grid {

    static final Double INCREMENT = 0.5;
    private static final int X = 180;
    private static final int Y = 360;

    private Area[][] map;

    public Grid(){
        map = new Area[X * 2][Y * 2];
    }

    public void addPoint(Double lat, Double lon){
        int x = X + scale(lat);
        int y = Y - scale(lon);

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

    public List<Area> getDenserArea(int n){
        return Arrays.stream(map)
                .flatMap(Arrays::stream)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Area::density).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    private int scale(Double value){
        Double rounded = (value <= 0 ? Math.floor(value) : Math.ceil(value)) / INCREMENT;
        return rounded.intValue();
    }
}
