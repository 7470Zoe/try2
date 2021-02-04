package com.syt;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	
	int x = 200;
	int  y  = 200;
	public TankFrame() {
		setVisible(true);
		setSize(800,600);
		setResizable(false);
		setTitle("tank war");
		this.addKeyListener(new MyKeyListener());
		
		//这个new WindowAdapter是一个匿名内部类
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO 自动生成的方法存根
				System.exit(0);
			}					
		});		
	}

	//只要对这个窗口有操作,比如移动,都会调用这个方法
	@Override
	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
		System.out.println("Graphics ");
		g.fillRect(x, y, 50, 50);
		x+=10;
		y+=10;
		
	}
	
	//键盘监听处理类   是一个命名的内部类
	class MyKeyListener extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
		
		}
		
	}
	
	
}
