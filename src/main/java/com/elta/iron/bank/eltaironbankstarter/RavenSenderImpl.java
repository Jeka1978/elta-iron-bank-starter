package com.elta.iron.bank.eltaironbankstarter;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
public class RavenSenderImpl implements RavenSender {

    private String destination = "dorn";

    @Override
    public void sendRaven(NotEnoughMoneyException ex) {
        System.out.println("raven was sent to "+destination+" "+ex.getMessage());
    }
}
