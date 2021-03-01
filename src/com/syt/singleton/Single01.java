package com.syt.singleton;

public class Single01 {
    //饿汉式
    private static final Single01 INSTANCE = new Single01();
    //要记得给出private的空参构造,不让别人new就是
    private Single01(){

    }

    public static Single01 getInstance() {
        return INSTANCE;
    }
}
