package com.happn.testback.business;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.happn.testback.business.Util.scale;

@Service
public class Grid {

    static final Double INCREMENT = 0.5;
    private static final int X = 180;
    private static final int Y = 360;

    private GridArea[][] map;

    public Grid(){
        map = new GridArea[X * 2][Y * 2];
    }

    public void addPoint(Point p){
        addPoint(p.getLat(), p.getLon());
    }

    public void addPoint(Double lat, Double lon){
        int x = (int)(X + scale(lat, INCREMENT) / INCREMENT);
        int y = (int)(Y - scale(lon, INCREMENT) / INCREMENT);

        GridArea a = map[x][y];
        if(a == null){
            a = new GridArea();
        }
        a.addPoint(new Point(lat, lon));

        map[x][y] = a;
    }

    public GridArea getAreaByMinLatAndMinLon(Double maxLat, Double minLon){
        int x = (int) (X + maxLat / INCREMENT);
        int y = (int) (Y - minLon / INCREMENT);
        return map[x][y];
    }

    public List<GridArea> getDenserArea(int n){
        return Arrays.stream(map)
                .flatMap(Arrays::stream)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(GridArea::density).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }
}
