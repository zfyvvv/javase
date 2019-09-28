package cn.zhoufy.go.composite;
/**
 * 1.针对树形结构文件，
 * 2.提取公共的部分：Component
 * 3.有额外的地方|功能，单独实现！
 * @author DELL
 *
 */
public interface Component {//抽象构件
	void operate();

}
interface Leaf extends Component{//叶子，
	@Override
	default void operate() {
		// TODO Auto-generated method stub
	}
}
interface Composite extends Component{//容器构件角色！
	@Override
	default void operate() {
		// TODO Auto-generated method stub
	}
	void add();
	void remove();
	Component getChilder();
}
