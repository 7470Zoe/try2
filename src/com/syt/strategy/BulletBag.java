package com.syt.strategy;

import com.syt.Tank;

public class BulletBag {
    Tank t;
    private FireStrategy fireStrategy;

    public BulletBag(FireStrategy fireStrategy) {
        this.fireStrategy = fireStrategy;
    }

    //出锦囊啦,我要出招啦,锦囊,代表发射,具体发射什么,就是我们的策略
    public void fireEnemies(){
       this.fireStrategy.fire( t);

    }
}
