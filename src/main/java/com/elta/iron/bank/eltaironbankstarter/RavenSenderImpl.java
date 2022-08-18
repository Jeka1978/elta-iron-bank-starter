package com.elta.iron.bank.eltaironbankstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
public class RavenSenderImpl implements RavenSender {

    @Autowired
    private IronBankPropertiesHolder propertiesHolder;

    @Override
    public void sendRaven(String exMsg) {
        System.out.println("raven was sent to "+propertiesHolder.getDestination()+" "+exMsg);
    }
}
