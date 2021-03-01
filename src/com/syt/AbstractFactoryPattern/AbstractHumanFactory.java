package com.syt.AbstractFactoryPattern;

import com.syt.AbstractFactoryPattern.A.Human;

public abstract class AbstractHumanFactory implements HumanFactory {


    protected Human createHuman(HumanEnum humanEnum) {
        Human human = null;
        //如果传过来的这个枚举是存在的
        if (!humanEnum.getValue().equals("")) {
            try {
                human = (Human) Class.forName(humanEnum.getValue()).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                //这样就没有找不到类的问题
            }
        }
        return human;
    }
}
