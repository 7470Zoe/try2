package com.syt;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
	
	static final int GAME_WIDTH=800,GAME_HEIGHT=600;
	
	Tank aTank = new Tank(200,200,Dir.DOWN,this);
//	Bullet bullet = new Bullet(300,300,Dir.DOWN);
	List<Bullet>bullets =new ArrayList<>();
	public TankFrame() {
		setVisible(true);
		setSize(GAME_WIDTH,GAME_HEIGHT);
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
	
//	用双缓冲解决闪烁问题
	Image offScreenImage = null;

	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	//只要对这个窗口有操作,比如移动,都会调用这个方法
	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹的数量"+ bullets.size(), 10,60);
		
		
		
		aTank.paint(g);
//		bullet.paint(g);
		for(int i = 0;i<bullets.size();i++) {
			bullets.get(i).paint(g);
		}
	
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
			case KeyEvent.VK_ENTER:
				aTank.fire();
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
	
	

