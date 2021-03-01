package com.syt.AbstractFactoryPattern;

import com.syt.AbstractFactoryPattern.A.Human;

public class MaleHumanFactory extends AbstractHumanFactory{
    //这个就要把AbstractHumanFactory抽象类实现的 抽象接口中的方法重写具体的方法体
    @Override
    public Human createYellowHuman() {
        Human human = super.createHuman(HumanEnum.YelloMaleHuman);
        //这里的super对应this,super是指父类
        return human;
    }

    @Override
    public Human createWhiteHuman() {
        return super.createHuman(HumanEnum.WhiteMaleHuman);
    }

    @Override
    public Human createBlackHuman() {
        return super.createHuman(HumanEnum.BlackMaleHuman);
    }
}
