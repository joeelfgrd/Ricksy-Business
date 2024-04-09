package org.example;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



class UfosPark implements GuestDispatcher{
    

    private double fee = 500d;
    private double credit = 3000;
    private final Map<String, String> flota = new HashMap<String, String>();
    
    UfosPark() {};

    void add(String ufoID) {
        flota.putIfAbsent(ufoID, null);
    }

    public void dispatch(PayMethod payMethod) {
        
        if (!flota.containsValue(payMethod.number())) {
            for (Map.Entry<String, String> entry : flota.entrySet()) {
                if (entry.getValue() == null && payMethod.pay(fee)) {
                    flota.put(entry.getKey(), payMethod.number());
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