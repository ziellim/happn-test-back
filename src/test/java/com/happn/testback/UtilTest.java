package com.happn.testback;

import org.junit.jupiter.api.Test;

import static com.happn.testback.Util.scale;

public class UtilTest {

    @Test
    public void testScale(){
        assert(scale(0.1, 0.5).equals(0.0));
        assert(scale(0.6, 0.5).equals(0.5));
        assert(scale(-4.8, 0.5).equals(-5.0));
    }
}
