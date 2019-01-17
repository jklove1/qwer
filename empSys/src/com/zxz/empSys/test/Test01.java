package com.zxz.empSys.test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.zxz.empSys.util.C3P0pool;

public class Test01 {
	
	@Test
	public void TestConnection() throws SQLException, PropertyVetoException {
		Connection connection=C3P0pool.getConnection();
		System.out.println(connection);
		connection.close();
	}

}
