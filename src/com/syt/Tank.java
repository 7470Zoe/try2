package com.syt;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	private int x,y;
	Dir dir =Dir.DOWN;
	private static final int speed = 5;
	private boolean moving = false;
	//tank类中new出的子弹,想要放在在tankframe中的话,tank类必须能访问tankframe这个对象,就是要持有这个对象的引用
	private TankFrame tf;
	
	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Tank(int x, int y, Dir dir,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}
	
	public Dir getDir() {
		return dir;
	}
	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public void paint(Graphics g) {
		Color c= g.getColor();
		g.setColor(Color.yellow);
		g.fillRect(x, y, 50, 50);
		g.setColor(c);
		move();
		
	}

	private void move() {
		if(!moving)return;
		switch(dir) {
		case LEFT:
			x-=speed;
			break;
		case RIGHT:
			x+=speed;
			break;
		case UP:
			y-=speed;
			break;
		case DOWN:
			y+=speed;
			break;
		}	
		
	}
	public void fire() {
		tf.bullets.add(new Bullet(this.x,y,this.dir,this.tf)) ;
	}

	
	
	
}
