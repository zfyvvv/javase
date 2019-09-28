package cn.zhoufy.go.composite;
/**
 * 1.������νṹ�ļ���
 * 2.��ȡ�����Ĳ��֣�Component
 * 3.�ж���ĵط�|���ܣ�����ʵ�֣�
 * @author DELL
 *
 */
public interface Component {//���󹹼�
	void operate();

}
interface Leaf extends Component{//Ҷ�ӣ�
	@Override
	default void operate() {
		// TODO Auto-generated method stub
	}
}
interface Composite extends Component{//����������ɫ��
	@Override
	default void operate() {
		// TODO Auto-generated method stub
	}
	void add();
	void remove();
	Component getChilder();
}
