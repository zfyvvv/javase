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
 * 1.�ڲ���ʵ�ֵ�����
 * ˽�л���������
 * ͨ���ڲ����ṩһ��ʵ����
 * �����ṩ��ȡʵ���ķ�����
 * 
 * @author DELL
 *
 */
public class MuThread09 {
	//˽�л���������
	private MuThread09() {}
	//ͨ���ڲ����ṩһ��ʵ����
	private static class Inner{
		private static MuThread09 mt=new MuThread09();
	}
	//�����ṩ��ȡʵ���ķ�����
	public static MuThread09 getInstance() {
		return Inner.mt;
	}
}



