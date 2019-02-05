package se.iths;

import junit.lab.Vehicle;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class VehicleTest {

    @Test
    public void carIsWorth90PercentOfNewPrice() {

        Vehicle myVehicle = new Vehicle(
                "Volvo",
                2019,
                100000,
                Vehicle.Condition.mint

        );

        Assert.assertEquals(
                100000,
                myVehicle.calculateVehicleValue()

        );


    }

    @Test
    public void carPriceDecreased20PercentPerYear() {

        Vehicle myVehicle = new Vehicle(
                "Volvo",
                2018,
                100000,
                Vehicle.Condition.mint

        );

        Assert.assertEquals(
                72000,
                myVehicle.calculateVehicleValue()

        );


    }

    @Test
    public void carPriceDecreased10ThousandDependingOnConditionUsed() {

        Vehicle myVehicle = new Vehicle(
                "Volvo",
                2019,
                100000,
                Vehicle.Condition.used

        );

        Assert.assertEquals(
                80000,
                myVehicle.calculateVehicleValue()

        );
    }

    @Test
    public void carPriceDecreased20ThousandDependingOnConditionCrap() {

        Vehicle myVehicle = new Vehicle(
                "Volvo",
                2019,
                100000,
                Vehicle.Condition.crap

        );

        Assert.assertEquals(
                70000,
                myVehicle.calculateVehicleValue()

        );
    }

    @Test
    public void carPriceDependingOnBrandFerrari() {

        Vehicle myVehicle = new Vehicle(
                "Ferrari",
                2019,
                100000,
                Vehicle.Condition.mint

        );

        Assert.assertEquals(
                110000,
                myVehicle.calculateVehicleValue()

        );
    }

    @Test
    public void carPriceDependingOnBrandLamborghini() {

        Vehicle myVehicle = new Vehicle(
                "Lamborghini",
                2019,
                100000,
                Vehicle.Condition.mint

        );

        Assert.assertEquals(
                100000,
                myVehicle.calculateVehicleValue()

        );
    }
}