package com.syt.strategy;

import com.syt.Bullet;
import com.syt.Dir;
import com.syt.Tank;

public class FourDirFireStrategy implements FireStrategy {

    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet. WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
                //这个dir就是4个方向的
            new Bullet(bX,bY,dir,t.group,t.tf) ;
        }
    }
}
