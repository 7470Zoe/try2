package com.syt.AbstractFactoryPattern;

import com.syt.AbstractFactoryPattern.A.Human;

public class NvWa {
    public static void main(String[] args) {
        MaleHumanFactory maleHumanFactory = new MaleHumanFactory();
        FemaleHumanFactory femaleHumanFactory = new FemaleHumanFactory();
        Human whiteHuman = maleHumanFactory.createWhiteHuman();
        Human yellowHuman = femaleHumanFactory.createYellowHuman();
        whiteHuman.gender();
        whiteHuman.cry();
        whiteHuman.laugh();
        yellowHuman.laugh();
        yellowHuman.gender();
    }
}
