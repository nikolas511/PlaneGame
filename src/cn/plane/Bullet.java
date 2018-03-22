package cn.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cn.util.Constant;

public class Bullet extends GameObject{
	double degree;
	public Bullet(){
		degree = Math.random()*Math.PI*2;
		speed=3;width=8;height=8;
		x=Constant.Grame_Width/2;
		y=Constant.Grame_Heigh/2;
	}
	public void draw(Graphics g){
		super.draw(g);
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.fillOval((int)x, (int)y, width, height);
		g.setColor(c);
	}
	public void move(){
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		if(x>=Constant.Grame_Width-width||x<=width){
			degree=Math.PI-degree;
		}
		if(y>=Constant.Grame_Heigh-height||y<=height+30){
			degree=-degree;
		}
	}
}
