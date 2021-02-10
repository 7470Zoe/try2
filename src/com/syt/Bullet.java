package com.syt;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private static final int speed =15;
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();
	private Dir dir;
	private int x,y;
	//如果持续发子弹,持续往list里加子弹的话,早晚会造成内存溢出
	private boolean live = true;
	private TankFrame tf;
	
	public Bullet( int x, int y,Dir dir,TankFrame tf) {
		this.dir = dir;
		this.x = x;
		this.y = y;
		this.tf = tf;
	}
	
	public void paint(Graphics g) {
		if(!live) {
			tf.bullets.remove(this);
		}
		Color c= g.getColor();
//		g.setColor(Color.red);
//		g.fillOval(x, y, WIDTH, HEIGHT);
//		g.setColor(c);
		
		switch (dir) {
		case LEFT :
			g.drawImage(ResourceMgr.bulletL, x, y,null);
			break;
		case RIGHT :
			g.drawImage(ResourceMgr.bulletR, x, y,null);
			break;
		case UP :
			g.drawImage(ResourceMgr.bulletU, x, y,null);
			break;
		case DOWN :
			g.drawImage(ResourceMgr.bulletD, x, y,null);
			break;
	
		}
		move();
		
	}
	private void move() {
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
		if(x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT)live = false;
		
	}


}
