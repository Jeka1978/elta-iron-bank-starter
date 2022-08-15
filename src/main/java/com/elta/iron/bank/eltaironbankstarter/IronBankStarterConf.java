package com.elta.iron.bank.eltaironbankstarter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Evgeny Borisov
 */
@Configuration
public class IronBankStarterConf {

    @Bean
    public RavenSender ravenSender(){
        return new RavenSenderImpl();
    }

    @Bean(name = "ironBankExceptionHandler")
    public ExceptionHandlerAspect exceptionHandlerAspect(){
        return new ExceptionHandlerAspect();
    }
}






