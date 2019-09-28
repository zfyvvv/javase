package cn.zfy.chatD2;
/**
 * 
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable {
	//控制台输入流；
	private BufferedReader console;
	//管道输出流；
	private DataOutputStream dos;
	//控制线程的标识；
	private boolean isRunning=true;
	//初始化控制台输出流
	public Send() {
		console=new BufferedReader(new InputStreamReader(System.in));
	}
	//初始化管道输出流；
	public Send(Socket soc) {
		this();
		try {
			dos=new DataOutputStream(soc.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			isRunning=false;
			CloseUtil.closeAll(dos,console);
		}
	}
	//从控制台获得信息
	private String getMsgFromConsor() {
		try {
			return console.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	//从控制台获得信息
	//并输出到管道中，传递到soc.getOutputStream()；
	public void send() {
	String msg=getMsgFromConsor();
		try {
			if(null!=msg&&!msg.equals("")) {
			dos.writeUTF(msg);
			dos.flush();}
		} catch (IOException e) {
			e.printStackTrace();
			isRunning=false;
			CloseUtil.closeAll(dos,console);
		}
	}
	
	//线程控制；
	public void run() {
		while(isRunning) {
			send();
		}
		
	}

}
