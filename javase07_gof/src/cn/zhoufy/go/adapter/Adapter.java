package cn.zhoufy.go.adapter;
/**
 * 1.���������Լ̳еķ�ʽ���䣬�̳�Adaptee,��ÿͻ���������ʵ�ֿͻ��Ľӿڣ�
 * @author DELL
 *
 */
public class Adapter extends Adaptee implements Target {

	@Override
	public void handleRequest() {
		super.request();
	}

}
