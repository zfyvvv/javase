package cn.zhoufy.g.mediator;

public interface Mediator {
	void register(String dname,Department d);//�����ⲿ�������ҵ����ã������н��еĺ��ģ�
	void command(String dname);//������ã�

}
