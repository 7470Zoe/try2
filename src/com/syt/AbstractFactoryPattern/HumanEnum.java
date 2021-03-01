package com.syt.AbstractFactoryPattern;

public enum HumanEnum {
    //把所有性别人种都定义进来
    YelloMaleHuman("com.syt.AbstractFactoryPattern.A.YellowMaleHuman"),
    YelloFemaleHuman("com.syt.AbstractFactoryPattern.A.YellowFemaleHuman"),
    WhiteFemaleHuman("com.syt.AbstractFactoryPattern.A.WhiteFemaleHuman"),
    WhiteMaleHuman("com.syt.AbstractFactoryPattern.A.WhiteMaleHuman"),
    BlackFemaleHuman("com.syt.AbstractFactoryPattern.A.BlackFemaleHuman"),
    BlackMaleHuman("com.syt.AbstractFactoryPattern.A.BlackMaleHuman");

    //属性可以在括号里
    private String value = "";
    HumanEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
