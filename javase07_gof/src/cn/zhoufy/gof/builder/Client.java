package cn.zhoufy.gof.builder;
/**
 * 1.������ģʽ�����츴�Ӷ���ʱ�����Ҷ���Ĺ��������һ����˳��
 * 2.�������װ����̷��룻�ֱ��ṩ��
 * 3.װ�为�𽫶��󼸸�ģ��װ��������������ļ���ģ��ֱ��������ĵط����죻��ʹ�ýӿڣ�����ƺ�ʵ�ַ��룡��
 * 4.���������
 * 5.���̣�
 *     ָ�������homeBuilder-->���������ģ��-->װ�����Ķ���-->����������
 * @author DELL
 *
 */
public class Client {
	public static void main(String[] args) {
		Home h=new ZfyHomeDirector(new ZfyHomeBuilder()).directHome();
		h.getCar();
		h.getHou();
		h.getMon();
		System.out.println(h.getMon().getName());
	}

}
