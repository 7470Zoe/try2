package com.syt;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private static final int speed =10;
	private static int WIDTH = 20,HEIGHT = 20;
	private Dir dir;
	private int x,y;
	
	public Bullet( int x, int y,Dir dir) {
		this.dir = dir;
		this.x = x;
		this.y = y;
	}
	
	public void paint(Graphics g) {
		Color c= g.getColor();
		g.setColor(Color.red);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
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
		
	}


}
