package cn.zfy.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 4、Udp在线案例1；
 * 接受数据；
 * @author DELL
 *
 */
public class TalkReceive implements Runnable{
	private DatagramSocket server;
	private String from;
	
	public TalkReceive(int port,String from) {
		this.from=from;
		try {
			server=new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true) {
			byte[] con;
			try {
				con=new byte[1024*64];
				DatagramPacket pac=new DatagramPacket(con, 0, con.length);
				server.receive(pac);
				byte[] data=pac.getData();
				int len=pac.getLength();
				String msg=new String(data,0,len);
				System.out.println(this.from+"说："+msg);
				if(msg.equals("byb")) {
					break;
					}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			server.close();
	}
	

}
