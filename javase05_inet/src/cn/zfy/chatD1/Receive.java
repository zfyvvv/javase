package cn.zfy.chatD1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive {
	private DataInputStream dis;

	public Receive(Socket soc) {
		try {
			dis=new DataInputStream(soc.getInputStream());
			System.out.println(dis.readUTF());
		} catch (IOException e) {
			if(dis!=null) {
				try {
					dis.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}
	/*public String printStr() {
		String str=" ";
		try {
			str=dis.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}*/
	

}
