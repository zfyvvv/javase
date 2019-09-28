package cn.zfy.multithread1_synchronized;

import java.security.Timestamp;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.TimeLimitExceededException;

/**
 * 1.synchronized关键字;
 * 同步粒度问题；
 * 尽量在商业开发中避免同步方法，使用同步代码块；细粒度解决同步问题，提高开发效率；
 * 
 * @author DELL
 *
 */
public class MultThread12 {
	
	synchronized void m1(){
		//前置逻辑
		System.out.println("同步逻辑");
		//后置逻辑
	}
	
	//m2要好于m1，只锁定同步逻辑；
	void m2(){
		//前置逻辑
		synchronized (this) {
			System.out.println("同步逻辑");
		}
		//后置逻辑
	}
}


