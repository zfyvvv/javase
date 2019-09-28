package cn.zfy.junit.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;


import cn.zfy.junit.Demo01;

/**
 * 1.Junit初级测试；
 * @author DELL
 *
 */
public class Demo01Test {

	@Test
	public void testAdd() {
		int result=new Demo01().add(3, 5);
		assertEquals(8, result);
		//assertTrue(message, condition);
		//assertTrue("z不大于10", result>10);
		//assertThat(result, is(8));
		assertThat(result, allOf(greaterThan(6),lessThan(10)));
	}
}
