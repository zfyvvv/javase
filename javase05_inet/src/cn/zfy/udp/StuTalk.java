package cn.zfy.udp;


/**
 * Udp���߰���1��
 * @author DELL
 *
 */
public class StuTalk {
	public static void main(String[] args) {
		//ѧ��������Ϣ
		new Thread(new TalkSend(8001, "localhost", 8002,"�ܷ���")).start();
		//ѧ��������Ϣ
		new Thread(new TalkReceive(8004,"�ܷ���")).start();
		
	}

}
