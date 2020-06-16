package com.example.config;

import com.example.multithread.SttServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(name = "sttServer")
    public SttServer sttServer() {
        return new SttServer();
    }

}
