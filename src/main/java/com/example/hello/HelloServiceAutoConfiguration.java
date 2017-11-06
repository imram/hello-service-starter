package com.example.hello;

import com.example.demo.ConsoleHelloService;
import com.example.demo.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ram Gupta on 5/13/2017.
 */
@Configuration
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnWrongArgument
public class HelloServiceAutoConfiguration {

    private HelloProperties helloProperties;
    @Autowired(required = false)
    private HelloServiceConfigurer helloServiceConfigurer;

    public HelloServiceAutoConfiguration(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    HelloService helloService() {
        String prefix;
        String suffix;
        HelloServiceConfiguration configuration = new HelloServiceConfiguration();;
        if(helloServiceConfigurer != null) {
            helloServiceConfigurer.configure(configuration);

        }

        prefix = configuration != null && configuration.getPrefix() != null ? configuration.getPrefix() : helloProperties.getPrefix();
        suffix = configuration != null && configuration.getSuffix() != null ? configuration.getSuffix() : helloProperties.getSuffix();


        return new ConsoleHelloService(prefix, suffix);
    }
}
