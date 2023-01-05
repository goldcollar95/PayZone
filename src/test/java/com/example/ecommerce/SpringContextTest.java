package com.example.ecommerce;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ECommerceApplication.class)
public class SpringContextTest {

    @Test
    public void whenSpringContextIsBootstrapped(){

    }
}
