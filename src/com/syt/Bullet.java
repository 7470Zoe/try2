package com.syt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
	private static final int speed =15;
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();
	private Dir dir;
	private int x,y;
	//如果持续发子弹,持续往list里加子弹的话,早晚会造成内存溢出
	private boolean living = true;
	private TankFrame tf = null;
	private Group group = Group.BAD;
	Rectangle rect = new Rectangle();
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Bullet( int x, int y,Dir dir,Group group,TankFrame tf) {
		this.dir = dir;
		this.x = x;
		this.y = y;
		this.group = group;
		this.tf = tf;
		rect.x = this.x;
		rect.y = this.y;
		rect.height = HEIGHT;
		rect.width = WIDTH;
	}
	
	public void paint(Graphics g) {
		if(!living) {
			tf.bullets.remove(this);
//			tf.bullets2.remove(this);
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
		//当x和y有变化时,要同步更新rect的值
		rect.x = this.x;
		rect.y = this.y;

		if(x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT)living = false;
		
	}

	public void collideWith(Tank tank) {
		if(this.group == tank.getGroup()) return;
		//子弹与坦克相撞的判断  Rectangle矩形 子弹的矩形
//		Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
//		Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
		
		if(rect.intersects(tank.rect)) {
			this.die();
			tank.die();
			int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
			int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
//			在碰撞检测的时候,会有爆炸
			tf.explodes.add(new Explode(eX,eY,tf));
		}
		
		
	}

	private void die() {
	
		this.living = false;
	}


}
