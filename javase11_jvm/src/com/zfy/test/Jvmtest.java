package com.zfy.test;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class Jvmtest {

	public static void main(String[] args) {
		List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();
		for(GarbageCollectorMXBean b:list) {
			System.out.println(b.getName());
		}
	}
}
