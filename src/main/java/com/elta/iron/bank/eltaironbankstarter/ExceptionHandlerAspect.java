package com.elta.iron.bank.eltaironbankstarter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */

public class ExceptionHandlerAspect implements MethodInterceptor {
    @Autowired
    private RavenSender ravenSender;



    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object retVal = null;
        try {
            retVal = invocation.proceed();
        } catch (NotEnoughMoneyException e) {
            ravenSender.sendRaven(e.getMessage());
            throw e;
        }
        return retVal;
    }
}





