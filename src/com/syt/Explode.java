package com.syt;

import java.awt.*;

public class Explode {
	//public static int WIDTH = ResourceMgr.explodes[10].getWidth();
	//public static int HEIGHT = ResourceMgr.explodes[10].getHeight();

	private int x,y;
	//如果持续发子弹,持续往list里加子弹的话,早晚会造成内存溢出
	TankFrame tf = null;
//	他展示到第几个了
	private int step = 0;



	public Explode(int x, int y, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.tf = tf;
	}
	
	public void paint(Graphics g) {
    	g.drawImage(ResourceMgr.explodes[step++] ,x,y,null);
    	if(step>=ResourceMgr.explodes.length)
    		step = 0;

	}







}
