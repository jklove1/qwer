package com.zxz.empSys.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

public class DBUtils {
	
	/**
	 * 创建并返回runner对象
	 * @return
	 * @throws PropertyVetoException
	 */
	public static QueryRunner Query() throws PropertyVetoException {
		DataSource source=C3P0pool.getDataSource();
		
		QueryRunner runner=new QueryRunner(source);
		return runner;
	}
	
	
}
