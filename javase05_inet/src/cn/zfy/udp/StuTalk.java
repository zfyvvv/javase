package cn.zfy.udp;


/**
 * Udp在线案例1；
 * @author DELL
 *
 */
public class StuTalk {
	public static void main(String[] args) {
		//学生发送消息
		new Thread(new TalkSend(8001, "localhost", 8002,"周方杨")).start();
		//学生接受消息
		new Thread(new TalkReceive(8004,"周方杨")).start();
		
	}

}
