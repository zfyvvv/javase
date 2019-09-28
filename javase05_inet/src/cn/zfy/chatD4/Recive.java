package cn.zfy.chatD4;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Recive implements Runnable {
	private DataInputStream dis;
	private boolean isRunning=true;
	
	public Recive() {
		
	}
	public Recive(Socket soc) {
		try {
			dis=new DataInputStream(soc.getInputStream());//输入流，
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isRunning=false;
			CloseUtil.closeAll(dis);
		}
	}

	private void recive() {
		try {
			String msg = dis.readUTF();//读取输入流中的数据并打印；
			System.out.println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isRunning=false;
			CloseUtil.closeAll(dis);
		}
	}

	public void run() {
		while(isRunning) {
			recive();//不断的读取并打印
		}
	}
	

}
