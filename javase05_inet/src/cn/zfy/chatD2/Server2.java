package cn.zfy.chatD2;
/**
 * 
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server2{
	private List<MyChannel> all=new ArrayList<MyChannel>();//构造器，肯定是一个方法！
	
	
public static void main(String[] args) throws IOException {
		new Server2().start();
	}



public void start() throws IOException {
	ServerSocket ser=new ServerSocket(10000);
	while(true) {
		Socket socs=ser.accept();
		MyChannel channel=new MyChannel(socs);
		all.add(channel);
		new Thread(channel).start();;
	}
}

private class MyChannel implements Runnable{
	private DataInputStream dis;
	private DataOutputStream dos;
	private boolean isRunning=true;
	private String name;
	
	public MyChannel(Socket soc) {
		try {
			dis=new DataInputStream(soc.getInputStream());
			dos=new DataOutputStream(soc.getOutputStream());
			this.name=dis.readUTF();
			System.out.println(this.name);
			
		} catch (IOException e) {
			//e.printStackTrace();
			CloseUtil.closeAll(dis,dos);
			isRunning=false;
		}
	}
	private String recive() {
		String msg="";
		try {
			msg=dis.readUTF();
		} catch (IOException e) {
			//e.printStackTrace();
			CloseUtil.closeAll(dis);
			isRunning=false;
			all.remove(this);
		}
		return  msg;
	}
	private void send(String msg) {
		//msg=this.recive()//???
		if(null==msg||msg.equals("")) {
			return ;
		}
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			//e.printStackTrace();
			CloseUtil.closeAll(dos);
			isRunning=false;
			all.remove(this);
		}
	}
	private void sendOthers() {
		String msg=this.recive();
		for(MyChannel temp:all) {
			//if(temp==this) {
				//continue;
			//}
			temp.send(msg);
		}
	}
	
	public void run() {
		while(isRunning) {
			sendOthers();
			//send(recive());
		}
	}
}
}