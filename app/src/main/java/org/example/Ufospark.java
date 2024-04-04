package org.example;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UfosPark implements PayMethod{
    private double fee = 500;
    private final Map<String, String> flota = new HashMap<String, String>();
    
    public UfosPark() {};
    
    public void add(String ufoID) {
        flota.putIfAbsent(ufoID, null);
    }
    
    public void dispatch(CreditCard card) {
        if (card.pay(fee)) {
            for (Map.Entry<String, String> entry : flota.entrySet()) {
                if (entry.getValue() == null) {
                    entry.setValue(card.number());
                    break;
                }
            }
        }
    }
    

    public String getUfoOf(String cardNumber){
        String ufoID = null;
        for (Map.Entry<String, String> entry : flota.entrySet()) {
            
            if (entry.getValue() == cardNumber) {
                ufoID = entry.getKey();
                break;
            }
    
        }
        return ufoID;
    }
    @Override
    public String toString() {
        return "UfosPark [fee=" + fee + ", flota=" + flota + "]";
    }
    boolean containsCard(String cardNumber) {
        return this.flota.containsValue(cardNumber);
    }

    Collection<String> cardNumbers() {
        return this.flota.values();
    }
} 