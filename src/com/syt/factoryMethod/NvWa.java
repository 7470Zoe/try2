package com.syt.factoryMethod;

public class NvWa {
    //要使用工厂的时候
    public static void main(String[] args) {
        Human human = HumanFactory.createHuman(WhiteHuman.class);
        human.cry();
        human.laugh();
        human.eat();
        Human human1 = HumanFactory.createHuman(BlackHuman.class);
        human1.cry();
        human1.laugh();
        human1.eat();
        Human human2 = HumanFactory.createHuman(YellowHuman.class);
        human2.cry();
        human2.laugh();
        human2.eat();
        //如上是造了三种特定的人
    }
}
