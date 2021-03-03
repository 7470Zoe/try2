package com.syt.AbstractFactoryPattern.A;

import com.syt.AbstractFactoryPattern.A.AbstractYellowHuman;

public class BlackMaleHuman extends AbstractBlackHuman {
    @Override
    public void gender() {
        System.out.println("该黑种人的性别为男...");
    }
}
