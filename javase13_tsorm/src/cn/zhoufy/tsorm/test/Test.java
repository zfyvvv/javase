package cn.zhoufy.tsorm.test;

import cn.zhoufy.tsorm.core.MysqlQuery;
import cn.zhoufy.tsorm.core.Query;
import cn.zhoufy.tsorm.core.QueryFactory;

public class Test {
	
	public static void test1() {
		Query q=QueryFactory.creatQuery();
		Object obj=q.queryValue("select count(*) from emp where id>?", new Object[] {1});
		System.out.println(obj);//查询符合条件字段的个数；
	}
	public static void test2() {
		long s=System.currentTimeMillis();
		for(int i=0;i<1000;i++) {
			test1();//不加连接池的时间：13599
			        //加连接池的时间：4158；
		}
		long e=System.currentTimeMillis();
		System.out.println("timesuming:"+(e-s));
	}
	
	public static void main(String[] args) {
		test1();
	}
		
}
