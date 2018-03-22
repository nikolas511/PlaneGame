package cn.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import cn.util.GameUtil;
import cn.util.MyFrame;
import cn.util.Constant;
public class PlaneGameFrame extends MyFrame{
	Plane plane1 = new Plane("images/plane01.png", 70, 70,10);
	ArrayList arraylist = new ArrayList();
	Explode explode;
	Date startTime;
	Date endTime;
	int time;
	String str;
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		plane1.draw(g);
	//	explode.draw(g);
		for(int j=0;j<arraylist.size();j++){
			Bullet b = (Bullet) arraylist.get(j);
			b.draw(g);
			//比较飞机和子弹碰撞
			boolean index = plane1.getRect().intersects(b.getRect());
			if(index){
				plane1.setLive(false);
				if(explode==null){
					endTime=new Date();
					explode	= new Explode(plane1.x, plane1.y);
				}
				explode.draw(g);
				break;
			}
		}
		if(!plane1.isLive()){
			time = (int)((endTime.getTime()-startTime.getTime())/1000);
			switch(time/10){
			case 0:
			case 1:str="菜鸟";break;
			case 2:
			case 3:str="大鸟";break;
			default : str="鸟人";break;
			}
			GameOver(g, "Game Over",80,140,220,Color.black);
			GameOver(g,"生存时间："+time+"秒->"+str,25,220,280,Color.black);
			super.setFlag(false);
		}
	}
	public void GameOver(Graphics g,String s,int size,int x,int y,Color color){
		Font font = new Font("宋体",Font.BOLD,size);
		g.setFont(font);
		g.setColor(color);
		g.drawString(s, x, y);
	}
	public static void main(String[] args) {
	PlaneGameFrame planegameframe = new PlaneGameFrame();
	planegameframe.launchFrame();
}
	public void launchFrame(){
		super.launchFrame();
		addKeyListener(new KeyMonitor());
		startTime = new Date();
		for(int i=0;i<40;i++){
			Bullet bullet = new Bullet();
			arraylist.add(bullet);
		}
	}
	/*
	 * 使用内部类方便调用外部类方法
	 */
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			plane1.addDirector(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plane1.cutDirector(e);
		}
		
	}
}
