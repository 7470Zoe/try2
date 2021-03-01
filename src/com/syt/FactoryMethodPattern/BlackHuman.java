package com.syt.FactoryMethodPattern;

public class BlackHuman implements Human{
    @Override
    public void laugh() {
        System.out.println("黑人笑");
    }

    @Override
    public void cry() {
        System.out.println("黑人哭");
    }

    @Override
    public void eat() {
        System.out.println("黑人吃");
    }
}
