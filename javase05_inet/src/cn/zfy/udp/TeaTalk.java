package cn.zfy.udp;
/**
 * Udp���߰���2��
 * @author DELL
 *
 */
public class TeaTalk {
	public static void main(String[] args) {
		//��ʦ������Ϣ
		new Thread(new TalkReceive(8002,"����")).start();
		//��ʦ����
		new Thread(new TalkSend(8003, "localhost", 8004,"��ʦ")).start();
	}

}
