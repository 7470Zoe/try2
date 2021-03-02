package com.syt.AbstractFactoryPattern;

import com.syt.AbstractFactoryPattern.A.Human;

public abstract class AbstractHumanFactory implements HumanFactory {
//因为是抽象类,虽然实现了接口,但是可以不写接口中的抽象方法

    //这里用抽象的工厂,是不想现在就把HumanFactory中的方法实现,写了一个实现方法是为了让别的继承了这个工厂类的去调用,

    protected Human createHuman(HumanEnum humanEnum) {
        Human human = null;
        //如果传过来的这个枚举是存在的
        if (!humanEnum.getValue().equals("")) {
            try {
                //目的是获取这个枚举类value所代表的com.syt.AbstractFactoryPattern.A.WhiteMaleHuman实例
                human = (Human) Class.forName(humanEnum.getValue()).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                //这样就没有找不到类的问题
            }
        }
        return human;
    }
}
