package com.syt.factoryMethod;

import sun.misc.ClassLoaderUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

//这是建人的工厂//忽略警告的注解
@SuppressWarnings("all")
public class HumanFactory {
    //在这个工厂方法里,不管里面的哪个方法,都只是返回了某个实现类
    /**
     * 这个方法的是体现 工厂方法设计模式的 延迟初始化的应用
     * 一个对象初始化完毕后就不释放，等到再次用到得就不用再次初始化了，直接从内存过中拿到就可以了
     *
     * 这个在类初始化很消耗资源的情况比较实用，
     * 比如你要连接硬件，或者是为了初始化一个类需要准备比较多条件（参数），
     * 通过这种方式可以很好的减少项目的复杂程度
     * @param c
     * @return
     */
    //定义一个hashmap,初始化的过的Human对象都放在这
    private static HashMap<String,Human> humans = new HashMap<String,Human>();
    public static Human createHuman(Class c){
        Human human = null;
        if (humans.containsKey(c.getSimpleName())) {
            human = humans.get(c.getSimpleName());
        }else{
            try {
                human = (Human)Class.forName(c.getName()).newInstance();
                humans.put(c.getSimpleName(),human);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return human;
    }

    //造人方法 造特定人种的人
    public static Human createHuman1(Class c){
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

    //造人方法 造随机人种的人
    public static Human createHuman(){
        Human human= null;
        //首先获得有多少种人种,就是Human的实现类有多少
        List<Class> concreteHumanList = ClassUtils.getAllClassByInterface(Human.class);
        Random random = new Random();
        int r = random.nextInt(concreteHumanList.size());
        human = createHuman1(concreteHumanList.get(r));
        return human;
    }
}
