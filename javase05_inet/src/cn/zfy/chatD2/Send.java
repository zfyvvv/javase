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
	//����̨��������
	private BufferedReader console;
	//�ܵ��������
	private DataOutputStream dos;
	//�����̵߳ı�ʶ��
	private boolean isRunning=true;
	//��ʼ������̨�����
	public Send() {
		console=new BufferedReader(new InputStreamReader(System.in));
	}
	//��ʼ���ܵ��������
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
	//�ӿ���̨�����Ϣ
	private String getMsgFromConsor() {
		try {
			return console.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	//�ӿ���̨�����Ϣ
	//��������ܵ��У����ݵ�soc.getOutputStream()��
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
	
	//�߳̿��ƣ�
	public void run() {
		while(isRunning) {
			send();
		}
		
	}

}
