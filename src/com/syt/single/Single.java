package com.syt.single;

public enum Single {
    //完美单例,既线程安全.又效率
    INSTANCE;
    //枚举单例


    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(Single.INSTANCE.hashCode());
            }).start();
        }
    }
}
