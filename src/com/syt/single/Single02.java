package com.syt.single;

public class Single02 {
    //懒汉式,用到才加载,不用不加载
    private static Single02 instance;
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
