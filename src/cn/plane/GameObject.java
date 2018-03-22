package cn.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import cn.util.GameUtil;

public class GameObject {
	Image img;
	double x,y;
	int speed;
	int width,height;
	public void draw(Graphics g){
		g.clearRect((int)x, (int)y, width, height);	//先擦除运动图像，使动画不重构*此擦除为矩形
		move();
	}
	public Rectangle getRect(){
		return new Rectangle((int)x,(int)y,width,height);
	}
	public void move(){
	}
	public GameObject(String imgpath, double x, double y, int speed) {
		this.img=GameUtil.getImage(imgpath);
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	public GameObject(){
	}
}
