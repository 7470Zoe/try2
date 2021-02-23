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
	
	static final int GAME_WIDTH=1000,GAME_HEIGHT=900;
	
	Tank aTank = new Tank(600,800,Dir.DOWN,Group.GOOD,this);
	Tank bTank = new Tank(200,800,Dir.DOWN,Group.GOOD,this);
//	Bullet bullet = new Bullet(300,300,Dir.DOWN);
	List<Bullet>bullets =new ArrayList<>();
	List<Bullet>bullets2 =new ArrayList<>();
	List<Tank>enemies =new ArrayList<>();
	//这里new出爆炸的时候,list里是空的
	List<Explode>explodes = new ArrayList<>();
//	Explode explode = new Explode(600,800,this);

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
		g.drawString("坦克子弹的数量"+ bullets.size(), 10,60);
//		为了单独计算tank2的子弹数量导致代码增加许多,应该把重复代码都抽离出方法来
//		g.drawString("坦克2子弹的数量"+ bullets2.size(), 10,75);
		g.drawString("敌方坦克的的数量"+ enemies.size(), 10,90);
		g.drawString("爆炸的数量"+ explodes.size(), 10,105);

//		explode.paint(g);
		
		
		aTank.paint(g);
		bTank.paint(g);
		//bullet.paint(g);
		for(int i = 0;i<bullets.size();i++) {
			bullets.get(i).paint(g);
		}
		/*
		 * for(int i = 0;i<bullets2.size();i++) { bullets2.get(i).paint(g); }
		 */
		
//		敌方坦克
		for(int i = 0;i<enemies.size();i++) {
			enemies.get(i).paint(g);
		}
//		各处的爆炸
		for(int i = 0;i<explodes.size();i++) {
			explodes.get(i).paint(g);
		}
		
//		判断子弹和坦克相撞的碰撞检测
		for(int i = 0;i<bullets.size();i++) {
			for(int j = 0;j<enemies.size();j++) {
				bullets.get(i).collideWith(enemies.get(j));
			}
		}

		/*
		 * for(int i = 0;i<bullets2.size();i++) { for(int j = 0;j<enemies.size();j++) {
		 * bullets2.get(i).collideWith(enemies.get(j)); } }
		 */
//		如下会报ConcurrentModificationException
//		for(Bullets b:bullets) {
//			b.paint(g);
//		}
	
	}
	
	//键盘监听处理类   是一个命名的内部类
	class MyKeyListener extends KeyAdapter{
		boolean bL= false;
		boolean bU= false;
		boolean bR= false;
		boolean bD= false;
		
		boolean b2L= false;
		boolean b2U= false;
		boolean b2R= false;
		boolean b2D= false;
		
		
		
		

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
			
			
			switch(key) {
			case KeyEvent.VK_A:
				b2L= true;
				break;
			case KeyEvent.VK_W:
				b2U= true;
				break;
			case KeyEvent.VK_D:
				b2R=true;
				break;
			case KeyEvent.VK_S:
				b2D=true;
				break;
			default:
				break;
			}
			setMainbTankDir();
			
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
			
			
			switch(key) {
			case KeyEvent.VK_A:
				b2L= false;
				break;
			case KeyEvent.VK_W:
				b2U= false;
				break;
			case KeyEvent.VK_D:
				b2R=false;
				break;
			case KeyEvent.VK_S:
				b2D=false;
				break;
			case KeyEvent.VK_F1:
//				bTank.fire();
//				bTank.fire2();
				break;
			default:
				break;
			}
			setMainbTankDir();
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
		
		private void setMainbTankDir() {
			if(!b2L&!b2R&!b2U&!b2D) {
				bTank.setMoving(false);
				}else {
				bTank.setMoving(true);
			}

			if(b2L)bTank.setDir(Dir.LEFT);
			if(b2U)bTank.setDir(Dir.UP);
			if(b2R)bTank.setDir(Dir.RIGHT);
			if(b2D)bTank.setDir(Dir.DOWN);
	}
		
		
	}
}
	
	

