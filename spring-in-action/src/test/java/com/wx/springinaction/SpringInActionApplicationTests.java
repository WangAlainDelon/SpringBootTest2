package com.wx.springinaction;

import com.wx.springinaction.service.Encoreable;
import com.wx.springinaction.service.Performance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringInActionApplicationTests {

    @Autowired
    private Performance performance;

    @Test
    void contextLoads() {
    }

    @Test
    void performance() {

        performance.perform("hello");
        Encoreable performance = (Encoreable) this.performance;
        performance.performEncore();
    }

}
