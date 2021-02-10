package com.syt;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	private int x,y;
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
	Dir dir =Dir.DOWN;
	private static final int speed = 5;
	private boolean moving = false;
	//tank类中new出的子弹,想要放在在tankframe中的话,tank类必须能访问tankframe这个对象,就是要持有这个对象的引用
	private TankFrame tf;
	private boolean living = true;
	public static int WIDTH = ResourceMgr.tankD.getWidth();
	public static int HEIGHT = ResourceMgr.tankD.getHeight();
	
	
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
		if(!living) tf.enemies.remove(this);
		Color c= g.getColor();
		switch (dir) {
		case LEFT :
			g.drawImage(ResourceMgr.tankL, x, y,null);
			break;
		case RIGHT :
			g.drawImage(ResourceMgr.tankR, x, y,null);
			break;
		case UP :
			g.drawImage(ResourceMgr.tankU, x, y,null);
			break;
		case DOWN :
			g.drawImage(ResourceMgr.tankD, x, y,null);
			break;
	
		}
			
			 
	
		/*
		 * g.setColor(Color.yellow); g.fillRect(x, y, 50, 50); g.setColor(c);
		 */
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
		int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
		tf.bullets.add(new Bullet(bX,bY,this.dir,this.tf)) ;
	}
	/*
	 * public void fire2() { int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2; int bY
	 * = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2; tf.bullets2.add(new
	 * Bullet(bX,bY,this.dir,this.tf)) ; }
	 */


	public void die() {
		// TODO 自动生成的方法存根
		this.living = false;
	}

	
	
	
}
