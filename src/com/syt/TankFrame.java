package com.syt;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	public TankFrame() {
		setVisible(true);
		setSize(800,600);
		setResizable(false);
		setTitle("tank war");
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO 自动生成的方法存根
				System.exit(0);
			}					
		});		
	}

	@Override
	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
		System.out.println("Graphics ");
		g.fillRect(200, 200, 50, 50);
	}
	
}
