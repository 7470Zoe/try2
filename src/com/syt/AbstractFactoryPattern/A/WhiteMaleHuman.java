package com.syt.AbstractFactoryPattern.A;

public class WhiteMaleHuman extends AbstractYellowHuman {
    @Override
    public void gender() {
        System.out.println("该白种人的性别为男...");
    }
}
