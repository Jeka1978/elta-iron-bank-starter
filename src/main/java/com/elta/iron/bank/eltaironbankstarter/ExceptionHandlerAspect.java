package com.elta.iron.bank.eltaironbankstarter;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */

@Aspect
public class ExceptionHandlerAspect {
    @Autowired
    private RavenSender ravenSender;

    @AfterThrowing(value = "execution(* com.elta.ironbank..*.*(..))",throwing = "ex")
    public void handleNotEnoughMoney(NotEnoughMoneyException ex){
        ravenSender.sendRaven(ex);
    }
}





