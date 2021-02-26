package com.syt.strategy;

import com.syt.Tank;

public interface FireStrategy {
    //发射子弹的策略  为了获得子弹射出时所在的位置
    public void fire(Tank t);
}
