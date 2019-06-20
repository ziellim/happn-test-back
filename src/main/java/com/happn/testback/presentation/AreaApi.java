package com.happn.testback.presentation;

import com.happn.testback.business.Grid;
import com.happn.testback.mapper.AreaMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v0/areas")
public class AreaApi {

    private Grid grid;

    private AreaMapper mapper;

    public AreaApi(Grid grid, AreaMapper mapper) {
        this.grid = grid;
        this.mapper = mapper;
    }

    @GetMapping
    public Area get(@RequestParam Double minLat, @RequestParam Double minLon){
        return mapper.toArea(grid.getAreaByMinLatAndMinLon(minLat, minLon));
    }
}
