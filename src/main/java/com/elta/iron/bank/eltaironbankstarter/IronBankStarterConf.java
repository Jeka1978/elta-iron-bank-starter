package com.elta.iron.bank.eltaironbankstarter;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Evgeny Borisov
 */



//in your starter create class which implements ApplicationContextInitializer
// declare it in spring.factories
@Configuration
@EnableConfigurationProperties(IronBankPropertiesHolder.class)
@ConditionalOnProperty("raven.destination")
public class IronBankStarterConf {

    @Bean
    public RavenSender ravenSender(){
        return new RavenSenderImpl();
    }

    @Bean
    public DefaultPointcutAdvisor customAdvisor() {
        return new DefaultPointcutAdvisor(exceptionPointcut(), exceptionHandlerAspect());
    }

    @Bean(name = "customExceptionPoint")
    public ExceptionPointcut exceptionPointcut(){
        return new ExceptionPointcut();
    }

    @Bean(name = "ironBankExceptionHandler")
    public ExceptionHandlerAspect exceptionHandlerAspect(){
        return new ExceptionHandlerAspect();
    }
}






