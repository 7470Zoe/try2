package com.syt.singleton;

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

    //枚举类不能被反序列化,因为枚举类没有构造方法,拿到class文件也不能构造对象
}
