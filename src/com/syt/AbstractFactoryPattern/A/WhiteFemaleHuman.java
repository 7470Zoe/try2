package com.syt.AbstractFactoryPattern.A;

public class WhiteFemaleHuman extends AbstractWhiteHuman {
    @Override
    public void gender() {
        System.out.println("该白种人的性别为女...");
    }
}
