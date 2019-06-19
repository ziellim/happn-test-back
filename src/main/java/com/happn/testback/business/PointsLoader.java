package com.happn.testback.business;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class PointsLoader {

    private File file;

    public PointsLoader(String filePath) {
        this.file = new File(filePath);
    }

    public List<Point> readPoints() throws IOException {
        return Files.lines(file.toPath())
                .skip(1)
                .map(line -> line.split(" "))
                .map(line -> new Point(Double.parseDouble(line[1]), Double.parseDouble(line[2])))
                .collect(Collectors.toList());
    }
}
