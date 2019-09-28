package cn.zfy.chatD1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send{
	private DataOutputStream dos;
	private BufferedReader br;
	private String msg;

	
	public Send(Socket soc) {
		try {
			br=new BufferedReader(new InputStreamReader(System.in));
			dos=new DataOutputStream(soc.getOutputStream());
		} catch (IOException e) {
			//e.printStackTrace();
			if(dos!=null) {
				try {
					dos.close();
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	public void send() {
		String msg=getMsg();
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			if(dos!=null) {
				try {
					dos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}
	private String getMsg() {
		try {
			this.msg=br.readLine();
		} catch (IOException e) {
			if(dos!=null) {
				try {
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		}
		return this.msg;
	}

}

