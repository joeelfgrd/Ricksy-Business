package org.example;

public class CreditCard implements PayMethod{

   private final String owner;
    private final String number;
    private double credit = 3000;
    private final String symbol = "EZI";

        public CreditCard(String owner, String number) {
            this.owner = owner;
            this.number = number;
        }
        
        
        public boolean pay(double cash) {
            boolean canPay = cash <= credit;
            credit = canPay ? credit - cash : credit;
            return canPay;
        }
        
        public String number() {
            return this.number;
        }

        String cardOwner() {
            return this.owner;
        }
        
        double credit() {
            return this.credit;
        }

        @Override
        public String toString() {
            return "owner: " + owner + 
            ", /nnumber: " + number + 
            ", /ncredit: " + credit  + symbol;
        }


    }