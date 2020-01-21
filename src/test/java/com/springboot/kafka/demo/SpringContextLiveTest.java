package com.springboot.kafka.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaDemoApplication.class)
public class SpringContextLiveTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
