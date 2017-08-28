package com.ak.learning.um.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.ak.learning.um.service" })
public class UmServiceConfig {

    public UmServiceConfig() {
        super();
    }

    // beans

}
