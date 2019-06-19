package com.happn.testback.business;

import com.google.common.io.Resources;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class PointsLoaderTest {

    @Test
    public void testReadPoins() throws IOException {
        // given
        PointsLoader reader = new PointsLoader(Resources.getResource("points.tsv").getPath());
        // when
        List<Point> points = reader.readPoints();
        // then
        assert(points.size() == 8);
        assert(points.get(7).getLon().equals(38.1));
    }
}
