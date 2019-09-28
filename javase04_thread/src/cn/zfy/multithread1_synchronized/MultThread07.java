package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import javax.naming.TimeLimitExceededException;

/**
 * 1.synchronized�ؼ���
 *ͬ������-�̳У�
 *����ͬ���������Ǹ���ͬ������������ָ�����ø����ͬ��������
 *�൱���������룻
 *
 * @author DELL
 *
 */
public class MultThread07 {
	
	synchronized void m() {
		System.out.println("super m start!");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("super m end!");
	}
	
	public static void main(String[] args) {
		Sub_MultThread07 mt7s = new Sub_MultThread07();
		mt7s.m();

	}
}

class Sub_MultThread07 extends MultThread07{
	synchronized void m() {
		System.out.println("sub m start!");
		super.m();
		System.out.println("sub m end!");
	}
}
