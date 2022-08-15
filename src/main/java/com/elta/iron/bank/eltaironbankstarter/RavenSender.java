package com.elta.iron.bank.eltaironbankstarter;

/**
 * @author Evgeny Borisov
 */
public interface RavenSender {
    void sendRaven(NotEnoughMoneyException ex);
}
