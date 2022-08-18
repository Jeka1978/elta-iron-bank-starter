package com.elta.iron.bank.eltaironbankstarter;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

/**
 * @author Evgeny Borisov
 */
public class ExceptionPointcut extends DynamicMethodMatcherPointcut {

    @Autowired
    private IronBankPropertiesHolder propertiesHolder;

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        return true;
    }

    @Override
    public ClassFilter getClassFilter() {
        return clazz -> clazz.getPackage().getName().startsWith(propertiesHolder.getPackagesToScan());
    }
}
