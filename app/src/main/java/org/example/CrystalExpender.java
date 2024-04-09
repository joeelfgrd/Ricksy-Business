package org.example;

public class CrystalExpender implements GuestDispatcher{
    private int stock=0;
    private double itemCost=0d;
    public CrystalExpender(int stock,double itemCost){
        this.stock=stock;
        this.itemCost=itemCost;
    }
    
    @Override
    public void dispatch(PayMethod paymethod){
        if(stock> 0  && paymethod.pay(itemCost)){
            stock -=1;
        }
    }
    public int stock(){
        return this.stock;
    }
    @Override
    public String toString(){
        return "stock" + this.stock + 
        "/ncost" + this.itemCost;

    }
}


