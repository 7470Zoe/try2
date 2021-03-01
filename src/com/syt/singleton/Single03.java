package com.syt.singleton;

public class Single03 {
    //由jvm 保证线程安全
    private Single03(){}

    //在私有内部类中new出唯一的实例
    //静态内部类,就是外部在加载的时候,内部不加载,所以既能保证单例 又能保证懒加载
    private static class Single03Provider{
        private static final Single03 instance = new Single03();
    }
    //在使用的时候,才去获取 被加载出来
    public static Single03 getInstance(){
        return Single03Provider.instance;
    }
}
