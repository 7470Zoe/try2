package com.syt.FactoryMethodPattern;

public class CarFactory {
    public Car createcar(){
        System.out.println("生产了一个car");
        return new Car();
    }
}
