package com.syt.AbstractFactoryPattern.A;

public class YellowFemaleHuman extends AbstractYellowHuman {
    @Override
    public void gender() {
        System.out.println("该黄种人的性别为女...");
    }
}
