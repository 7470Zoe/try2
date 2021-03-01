package com.syt.AbstractFactoryPattern.A;

public abstract class AbstractYellowHuman implements Human {
    @Override
    public void cry() {
        System.out.println("黄色人种会哭");
    }

    @Override
    public void laugh() {
        System.out.println("黄色人种会大笑，幸福呀！");
    }

    @Override
    public void talk() {
        System.out.println("黄色人种会说话，一般说的都是双字节");
    }

    //但是没有重写性别这个方法
    //某类东西 有一堆方法是共同的,有一些方法又是不同的,使用抽象工厂模式
    //把不论相同还是不相同的 给写成一个接口interface
    //在抽象类中实现接口,重写那些个相同的方法
    //然后某类东西独有的特点(比如人类的性别的不同的)  就写一个子类去继承抽象类,重写它实现的接口中的方法
}
