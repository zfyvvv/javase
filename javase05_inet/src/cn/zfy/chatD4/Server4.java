package cn.zfy.chatD4;
/**
 * Ⱥ�ģ�����ͬʱ���죻
 * ˽�ģ���������Īһ���ˣ�
 * ϵͳ��Ϣ���������е��ˣ�Socket��
 * ˼·��channel�ı�����һ������Socket��name�����ԵĶ���!
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server4{
	private List<MyChannel> all=new ArrayList<MyChannel>();//���������϶���һ���������½�ͨ�����ϣ���������ͨ��������Ϣ��
	private List<String> nalist=new ArrayList<String>();//�½�����ͨ���������������ӡ���֣�
	
public static void main(String[] args) throws IOException {
		new Server4().start();
	}

public void start() throws IOException {
	ServerSocket ser=new ServerSocket(10000);//�½���������
	while(true) {//��������У�
		Socket socs=ser.accept();
		MyChannel channel=new MyChannel(socs);
		all.add(channel);
		nalist.add(channel.name);
		System.out.print("��������ǰ����������"+all.size()+";"+"\t");
		System.out.println("���Ƿֱ��ǣ�"+channel.printName(nalist));
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
			this.send("ϵͳ��Ϣ��"+"��ӭ"+this.name+"���������ң�");//���͸��ͻ��Լ���
			this.sendOthers("�Ѿ����������ң�",true);
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
				if(temp.name.equals(name)) {//ͨ������msg��@�����ֺ�ͨ���е�������ͬ����ô��ֻת����@���ֵĿͻ���˭ת�������߳̿ͻ�����
					temp.send(this.name+"�������ĵ�˵��"+content);
				}
			}
		}else {
			if(sys) {
				for(MyChannel temp:all) {
					if(temp==this) {
						continue;
					}
					temp.send("ϵͳ��Ϣ��"+this.name+msg);}
			}else {
			for(MyChannel temp:all) {
				if(temp==this) {
					continue;
				}
				temp.send(this.name+"�Դ��˵��"+msg);
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