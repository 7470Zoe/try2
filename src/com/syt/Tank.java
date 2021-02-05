package com.syt;

import java.awt.Graphics;

public class Tank {
	private int x,y;
	Dir dir =Dir.DOWN;
	private static final int speed = 10;
	
	public Tank(int x, int y, Dir dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public Dir getDir() {
		return dir;
	}
	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public void paint(Graphics g) {
		g.fillRect(x, y, 50, 50);
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
	
}
