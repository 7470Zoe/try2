package com.syt.FactoryMethodPattern;

public class WhiteHuman implements Human{
    @Override
    public void laugh() {
        System.out.println("白人笑");
    }

    @Override
    public void cry() {
        System.out.println("白人哭");
    }

    @Override
    public void eat() {
        System.out.println("白人吃");
    }
}
