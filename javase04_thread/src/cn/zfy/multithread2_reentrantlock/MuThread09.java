package cn.zfy.multithread2_reentrantlock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.zfy.test.Test02;
/**
 * 1.内部类实现单例；
 * 私有化构造器；
 * 通过内部类提供一个实例；
 * 对外提供获取实例的方法；
 * 
 * @author DELL
 *
 */
public class MuThread09 {
	//私有化构造器；
	private MuThread09() {}
	//通过内部类提供一个实例；
	private static class Inner{
		private static MuThread09 mt=new MuThread09();
	}
	//对外提供获取实例的方法；
	public static MuThread09 getInstance() {
		return Inner.mt;
	}
}



