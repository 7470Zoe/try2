package com.syt.AbstractFactoryPattern.A;

public abstract class AbstractBlackHuman implements Human {
    @Override
    public void cry() {
        System.out.println("黑色人种会哭");
    }

    @Override
    public void laugh() {
        System.out.println("黑色人种会大笑！");
    }

    @Override
    public void talk() {
        System.out.println("黑色人种会说话，一般说的都是Rap");
    }
}
