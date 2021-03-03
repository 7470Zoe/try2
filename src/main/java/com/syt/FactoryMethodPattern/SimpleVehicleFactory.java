package com.syt.FactoryMethodPattern;

public class SimpleVehicleFactory {
    //简单工厂,可扩展性差
    public Car createcar(){
        return new Car();
    }
    public Palne createPalne(){
        return new Palne();
    }
}
