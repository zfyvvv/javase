package cn.zfy.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 3、Udp在线案例1；
 * 发送数据；
 * @author DELL
 *
 */
public class TalkSend implements Runnable{
	
	private DatagramSocket client;
	private BufferedReader reader;
	private String toIp;
	private int toPort;
	private String name;
	
	public TalkSend(int port,String toIp,int toPort,String name) {
		this.toIp=toIp;
		this.toPort=toPort;
		try {
			client=new DatagramSocket(port);
			reader=new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true) {
			String msg;
			try {
				msg=reader.readLine();
			byte[] data=msg.getBytes();
			DatagramPacket pac=new DatagramPacket(data,data.length,
					new InetSocketAddress(this.toIp,this.toPort));
				client.send(pac);
				if("byb".equals(msg)) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		client.close();

}
}
