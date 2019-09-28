package cn.zfy.udp;
/**
 * Udp在线案例2；
 * @author DELL
 *
 */
public class TeaTalk {
	public static void main(String[] args) {
		//老师接受信息
		new Thread(new TalkReceive(8002,"刘婷")).start();
		//老师发送
		new Thread(new TalkSend(8003, "localhost", 8004,"老师")).start();
	}

}
