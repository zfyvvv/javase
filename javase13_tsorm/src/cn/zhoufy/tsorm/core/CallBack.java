package cn.zhoufy.tsorm.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface CallBack {//�ڲ��ص���
	public Object doExecute(Connection conn,PreparedStatement ps,ResultSet rs);

}
