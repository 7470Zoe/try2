package com.syt;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class ResourceMgr{
	public static BufferedImage tankL,tankU,tankR,tankD,bulletL,bulletU,bulletR,bulletD;
	public static  BufferedImage[] explode = new BufferedImage[16];
	static {
		try {
			tankL=ImageIO.read( ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
			tankU=ImageIO.read( ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
			tankR=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
			tankD=ImageIO.read( ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
			
			bulletL=ImageIO.read( ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
			bulletU=ImageIO.read( ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
			bulletR=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
			bulletD=ImageIO.read( ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			for (int i = 0; i < 16; i++) {
				ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif");
			}

		}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
