package com.syt;

import java.awt.Frame;


public class Main {

	public static void main(String[] args) throws InterruptedException {
		TankFrame tf = new TankFrame();
//		初始化坦克
		for(int i = 0;i<5;i++) {
			tf.enemies.add(new Tank(50+i*80,200,Dir.DOWN,tf));
		}
		
		while(true) {
			Thread.sleep(50);
			tf.repaint();
		}

	}

}
