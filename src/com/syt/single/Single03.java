package com.syt.single;

public class Single03 {
    //由jvm 保证线程安全
    private Single03(){}

    //在私有内部类中new出唯一的实例
    private static class Single03Provider{
        private static final Single03 instance = new Single03();
    }
    //在使用的时候,才去获取 被加载出来
    public static Single03 getInstance(){
        return Single03Provider.instance;
    }
}
