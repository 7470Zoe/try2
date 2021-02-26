package com.syt;

import java.awt.*;
import java.util.Random;

public class Tank {
    //策略模式
    //想要用的时候,把锦囊(),定义为要用的这个类的成员变量,或者让那个接口(FireStrategy)作为参数,传到这个类的fire方法中
    public int x, y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir dir = Dir.DOWN;
    private static final int speed = 5;
    private boolean moving = true;
    //tank类中new出的子弹,想要放在在tankframe中的话,tank类必须能访问tankframe这个对象,就是要持有这个对象的引用
    public TankFrame tf = null;
    private boolean living = true;
    private Random r = new Random();
    public Group group = Group.BAD;
    Rectangle rect = new Rectangle();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();

    public void setLiving(boolean living) {
        this.living = living;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = this.x;
        rect.y = this.y;
        rect.height = HEIGHT;
        rect.width = WIDTH;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        if (!living) tf.enemies.remove(this);

        Color c = g.getColor();
        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;

        }

        move();

        /*
         * g.setColor(Color.yellow); g.fillRect(x, y, 50, 50); g.setColor(c);
         */


    }

    private void move() {

        if (!moving) return;
        if (!living) return;
        switch (dir) {
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
        }


        if (this.group == Group.BAD && r.nextInt(100) > 95) this.fire();
        if (this.group == Group.BAD && r.nextInt(20) > 18) randomDir();

//		在tank的move方法中做边界检测
        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    public void boundsCheck() {
//		x.和y指的是左上角
        if (this.x < 2) x = 2;
        if (this.y < 28) y = 28;
//		这个要包括tank自身的宽度和高度
        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
        //如果if语句下只有一句话要执行,一行代码,可以不加括号
    }

    public void randomDir() {
        //数组中的是随机出的下标
        this.dir = Dir.values()[r.nextInt(4)];
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.bullets.add(new Bullet(bX, bY, this.dir, this.group, this.tf));
    }
    /*
     * public void fire2() { int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2; int bY
     * = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2; tf.bullets2.add(new
     * Bullet(bX,bY,this.dir,this.tf)) ; }
     */


    public void die() {
        this.living = false;
    }


}
