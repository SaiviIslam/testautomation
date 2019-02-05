package junit.lab;

import java.util.concurrent.locks.Condition;

public class Vehicle {

    private String make;
    private int yearOfManufacturing;
    private int newPrice;
    private Condition condition;

    public Vehicle(String make, int yearOfManufacturing, int newPrice, Condition condition){
        this.make = make;
        this.condition = condition;
        this.newPrice = newPrice;
        this.yearOfManufacturing = yearOfManufacturing;
    }

    public int calculateVehicleValue() {
        int price = newPrice * 9 / 10;

        for (int i = 2019; i > yearOfManufacturing; i--) {
            price = price * 8 / 10;

        }
        if(condition == condition.used) {

            price = price - 10000;
        }
        else if(condition == condition.crap){
            price = price-20000;
        }

        if(make == "Ferrari"){
            price = price+20000;
        }
        else if(make == "Lamborghini"){
            price = price+10000;
        }

        return price;

    }

    public enum Condition{
        mint,
        used,
        crap
    }
}
