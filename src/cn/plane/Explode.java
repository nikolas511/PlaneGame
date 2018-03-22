package cn.plane;

import java.awt.Graphics;
import java.awt.Image;

import cn.util.GameUtil;

public class Explode {
	double x,y;
	int count;
	static Image[] imgs = new Image[7];
	static{
		for(int i=0;i<7;i++){
			imgs[i]=GameUtil.getImage("images2/e0"+(i+1)+".png");
			imgs[i].getWidth(null);
		}
	}
	public void draw(Graphics g){
		if(count<=6){
			g.drawImage(imgs[count],(int)x, (int)y, null);
			count++;
		}
	}
	public Explode(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
}
