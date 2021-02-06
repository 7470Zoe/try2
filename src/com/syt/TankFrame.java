package com.syt;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	
	
	Tank aTank = new Tank(200,200,Dir.DOWN);
	Tank bTank = new Tank(200,200,Dir.DOWN);
	
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
		aTank.paint(g);
	}
	
	//键盘监听处理类   是一个命名的内部类
	class MyKeyListener extends KeyAdapter{
		boolean bL= false;
		boolean bU= false;
		boolean bR= false;
		boolean bD= false;

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch(key) {
			case KeyEvent.VK_LEFT:
				bL= true;
				break;
			case KeyEvent.VK_UP:
				bU= true;
				break;
			case KeyEvent.VK_RIGHT:
				bR=true;
				break;
			case KeyEvent.VK_DOWN:
				bD=true;
				break;
			default:
				break;
			}
			setMainTankDir();
			
		}


		//抬起键盘的时候应该给设置为false
		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch(key) {
			case KeyEvent.VK_LEFT:
				bL= false;
				break;
			case KeyEvent.VK_UP:
				bU= false;
				break;
			case KeyEvent.VK_RIGHT:
				bR=false;
				break;
			case KeyEvent.VK_DOWN:
				bD=false;
				break;
			default:
				break;
			}
			setMainTankDir();
		}
		

		private void setMainTankDir() {
			if(!bL&!bR&!bU&!bD) {
				aTank.setMoving(false);
				}else {
				aTank.setMoving(true);	
			}
			
			if(bL)aTank.setDir(Dir.LEFT);
			if(bU)aTank.setDir(Dir.UP);
			if(bR)aTank.setDir(Dir.RIGHT);
			if(bD)aTank.setDir(Dir.DOWN);
		
		
		
	}
	}
}
	
	

