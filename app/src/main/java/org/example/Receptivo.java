package org.example;

import java.util.HashSet;
import java.util.Set;

class Receptivo {
    
    private Set<GuestDispatcher> observers = new HashSet<>();

    void registra(GuestDispatcher observer) {
        observers.add(observer);
    }

    void dispatch(CreditCard card) {
        for (GuestDispatcher observer: observers) {
            observer.dispatch(card);
        }
    }
}