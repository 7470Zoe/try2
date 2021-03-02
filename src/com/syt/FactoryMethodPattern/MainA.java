package com.syt.FactoryMethodPattern;

public class MainA {
    public static void main(String[] args) {
        Vehicle v = new CarFactory().createcar();
        v.go();
    }
}
