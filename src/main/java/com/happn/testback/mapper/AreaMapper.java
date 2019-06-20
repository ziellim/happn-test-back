package com.happn.testback.mapper;

import com.happn.testback.presentation.Area;
import com.happn.testback.business.GridArea;
import org.springframework.stereotype.Service;

@Service
public class AreaMapper {

    public Area toArea(GridArea gridArea){
        Area area = new Area();
        if(gridArea == null){
            area.setDensity(0);
        }
        else{
            area.setMinLat(gridArea.getMinLat());
            area.setMaxLat(gridArea.getMaxLat());
            area.setMinLon(gridArea.getMinLon());
            area.setMaxLon(gridArea.getMaxLon());
            area.setDensity(gridArea.density());
        }
        return area;
    }
}
