package com.syt.factoryMethod;

import sun.misc.ClassLoaderUtil;

import java.util.List;

//这是建人的工厂
public class HumanFactory {
    //一个造人方法 造特定人种的人
    public static Human createHuman(Class c){
        Human human = null;
        //这代表传过来的是哪个就是哪个
        try {
            human = (Human)Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            System.out.println("必须指定人种的颜色");
        } catch (IllegalAccessException e) {
            System.out.println("人种定义错误！");
        } catch (ClassNotFoundException e) {
            System.out.println("混蛋，你指定的人种找不到！");
        }
        return human;
    }

    //造随机人种的人
    public static Human createHuman(){
        //首先获得有多少种人种,就是Human的实现类有多少
        List<Class> concreteHumanList = ClassUtils.getAllClassByInterface(Human.class);
        return null;
    }
}
