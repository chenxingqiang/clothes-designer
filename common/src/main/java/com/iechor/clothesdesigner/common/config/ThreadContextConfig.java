package com.iechor.clothesdesigner.common.config;

import com.iechor.clothesdesigner.common.util.S2ThreadContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThreadContextConfig {

    @Bean
    public S2ThreadContext s2ThreadContext() {
        return new S2ThreadContext();
    }
}
