package cn.zfy.junit.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.core.Is;
import org.junit.Test;

import cn.zfy.junit.User;

public class UserTest {
	
	@Test
	public void testGetStart() {
		String result=new User().getStart();
		assertThat(result, is("÷‹∑Ω—Ó"));
	}

}
