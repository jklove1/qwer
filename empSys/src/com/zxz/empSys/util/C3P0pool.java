package com.zxz.empSys.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * c3p0连接池
 * @author Administrator
 *
 */
public class C3P0pool {
	
	/**
	 * 获取数据源对象
	 * @return
	 * @throws PropertyVetoException
	 */
	public static DataSource getDataSource() throws PropertyVetoException {
		
		ComboPooledDataSource source=new ComboPooledDataSource();
		
		return source;
	}
	
	/**
	 * 获取连接对象
	 * @throws PropertyVetoException 
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException, PropertyVetoException {
		return getDataSource().getConnection();
	}
}
