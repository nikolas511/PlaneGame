package cn.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/*
 * 创建窗口
 * 设置大小
 */

public class MyFrame extends Frame{
	/*
	 * 使用双缓冲技术使屏幕不再闪烁
	 */
	private Image offScreenImage = null;
	public void update(Graphics g){
		if(offScreenImage==null){
			offScreenImage=this.createImage(Constant.Grame_Width,Constant.Grame_Heigh);
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0,null);
	}
	public void launchFrame(){
		setSize(Constant.Grame_Width,Constant.Grame_Heigh);
		setLocation(100, 100);
		setVisible(true);
		new repaintThread().start();
		addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		
	});
	}
	boolean flag=true;
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	class repaintThread extends Thread{
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(!flag)break;
			}
		}
	}
}
