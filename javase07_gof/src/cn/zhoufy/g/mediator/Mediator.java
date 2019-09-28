package cn.zhoufy.g.mediator;

public interface Mediator {
	void register(String dname,Department d);//持外外部的引用我的引用，这是中介中的核心！
	void command(String dname);//对外调用，

}
