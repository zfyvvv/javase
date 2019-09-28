package cn.zfy.chatD4;
/**
 * 群聊，多人同时聊天；
 * 私聊，单独发给莫一个人；
 * 系统消息：发给所有的人（Socket）
 * 思路：channel的本质是一个包含Socket和name等属性的对象!
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server4{
	private List<MyChannel> all=new ArrayList<MyChannel>();//构造器，肯定是一个方法！新建通道集合，方便给哥哥通道发送信息；
	private List<String> nalist=new ArrayList<String>();//新建集合通道，方便服务器打印名字；
	
public static void main(String[] args) throws IOException {
		new Server4().start();
	}

public void start() throws IOException {
	ServerSocket ser=new ServerSocket(10000);//新建服务器；
	while(true) {//不间断运行；
		Socket socs=ser.accept();
		MyChannel channel=new MyChannel(socs);
		all.add(channel);
		nalist.add(channel.name);
		System.out.print("服务器当前在线人数："+all.size()+";"+"\t");
		System.out.println("他们分别是："+channel.printName(nalist));
		new Thread(channel).start();;
	}
}

private class MyChannel implements Runnable{
	private DataInputStream dis;
	private DataOutputStream dos;
	private boolean isRunning=true;
	private String name;
	private boolean sys;
	
public MyChannel(Socket soc) {
		try {
			dis=new DataInputStream(soc.getInputStream());
			dos=new DataOutputStream(soc.getOutputStream());
			this.name=dis.readUTF();
			this.send("系统消息："+"欢迎"+this.name+"进入聊天室！");//发送给客户自己；
			this.sendOthers("已经进入聊天室！",true);
		} catch (IOException e) {
			//e.printStackTrace();
			CloseUtil.closeAll(dis,dos);
			isRunning=false;
			all.remove(this);
			nalist.remove(this.name);
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
	private void sendOthers(String msg,boolean sys) {
		if(msg.startsWith("@")&&msg.indexOf(":")>-1) {
			String name=msg.substring(1, msg.indexOf(":"));
			String content=msg.substring(msg.indexOf(":")+1);
			for(MyChannel temp:all) {//
				if(temp.name.equals(name)) {//通过解析msg中@的名字和通道中的名字相同，那么就只转发到@名字的客户，谁转发？该线程客户名字
					temp.send(this.name+"对您悄悄的说："+content);
				}
			}
		}else {
			if(sys) {
				for(MyChannel temp:all) {
					if(temp==this) {
						continue;
					}
					temp.send("系统消息："+this.name+msg);}
			}else {
			for(MyChannel temp:all) {
				if(temp==this) {
					continue;
				}
				temp.send(this.name+"对大家说："+msg);
		}}
		
		
		
		}
	}
	
	public void run() {
		while(isRunning) {
			sendOthers(this.recive(),sys);
			//send(recive());
		}
	}
	private String printName(List<String> list) {
		StringBuffer nalist=new StringBuffer();
		for(int i=0;i<list.size();i++) {
			nalist.append(list.get(i)).append("\t");
		}
		String nali=nalist.toString();
		return nali;
	}
}
}