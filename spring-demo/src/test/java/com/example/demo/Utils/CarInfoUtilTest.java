package com.example.demo.Utils;

import com.example.demo.Annotation.BMW;
import org.junit.Test;

public class CarInfoUtilTest {

    @Test
    public void getFruitInfo() {
        CarInfoUtil.getFruitInfo(BMW.class);
    }
}