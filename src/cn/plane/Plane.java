package cn.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import cn.util.Constant;
import cn.util.GameUtil;

public class Plane extends GameObject{
	boolean left,up,right,down;
	boolean live;
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public void draw(Graphics g){
		/*
		 * ����ɻ������˶���ͼ
		 * �ɻ����� �����ɻ��켣
		 */
		if(isLive()){
			super.draw(g);
			g.drawImage(img, (int)x, (int)y, null);	//���˶�ͼ��
		}
	}
	public void move() {
		if(left){
			if(x<=10){
			}else
			x-=speed;
		}
		if(up){
			if(y<=36){
			}else
			y-=speed;
		}
		if(right){
			if(x>=Constant.Grame_Width-60){	
			}else
			x+=speed;
		}
		if(down){
			if(y>=Constant.Grame_Width-145){
			}
			else
			y+=speed;
		}
	}
	public void addDirector(KeyEvent e) {
		switch(e.getKeyCode()){
		case 37: this.left=true;break;
		case 38: this.up=true;break;
		case 39: this.right=true;break;
		case 40: this.down=true;break;
		default : break;
		}
	}
	public void cutDirector(KeyEvent e) {
		switch(e.getKeyCode()){
		case 37: this.left=false;break;
		case 38: this.up=false;break;
		case 39: this.right=false;break;
		case 40: this.down=false;break;
		default : break;
		}
	}
	public Plane(String imgpath, double x, double y,int speed) {
		super(imgpath,x,y,speed);
		width=img.getWidth(null);		//�ɻ�ͼƬ�Ŀ��
		height=img.getHeight(null);		//�ɻ�ͼƬ�ĸ߶�
		live=true;						//��ʼ���ɻ�״̬
	}
	public Plane(){
	}
}
