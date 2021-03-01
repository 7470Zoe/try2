package com.syt.SingletonPattern;

public class Single02 {
    //懒汉式,用到才加载,不用不加载
    //这里要加volatile java汇编语句优化时,有语句重排,很频繁,不加volatile的话,会在没初始化的时候就返回这个instance  重点
    private static volatile Single02 instance;
    private Single02(){}


    public static Single02 getInstance(){
        //上两层锁的目的,就是为了更高效
        if(instance==null){
            //这个锁是当前这个类
            synchronized (Single02.class){
                if(instance==null){
                    instance=  new Single02();
            }}
        }
        return instance;
    }

}
