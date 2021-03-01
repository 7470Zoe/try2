package com.syt.FactoryMethodPattern;

public class YellowHuman implements Human{
    @Override
    public void laugh() {
        System.out.println("黄人大笑");
    }

    @Override
    public void cry() {
        System.out.println("黄人小小哭");
    }

    @Override
    public void eat() {
        System.out.println("黄人吃大餐");
    }
}
