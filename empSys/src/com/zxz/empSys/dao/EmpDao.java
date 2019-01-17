package com.zxz.empSys.dao;

import java.beans.PropertyVetoException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zxz.empSys.domain.Emp;
import com.zxz.empSys.util.DBUtils;

public class EmpDao implements IEmpDao {

	@Override
	public Emp findEmpByNmaeAndPassword(String name, String password) {
		try {
			QueryRunner runner = DBUtils.Query();
			String sql = "select * from emp where name=? and password=?";
			return (Emp) runner.query(sql, new BeanHandler<Emp>(Emp.class), name, password);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Emp> findAll() {

		try {
			QueryRunner runner = DBUtils.Query();
			String sql = "select * from emp";
			return runner.query(sql, new BeanListHandler<Emp>(Emp.class));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void Add(Emp emp) {
		try {
			QueryRunner runner = DBUtils.Query();
			String sql = "insert into emp values(null,?,?,?,?,?,?,?,?)";
			String name = emp.getName();
			String password = emp.getPassword();
			String gender = emp.getGender();
			Integer age = emp.getAge();
			Date hiredate = emp.getHiredate();
			double salary = emp.getSalary();
			String phone = emp.getPhone();
			String emali = emp.getEmali();
			runner.update(sql, name, password, gender, age, hiredate, salary, phone, emali);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Emp findById(int id) {
		try {
			QueryRunner runner = DBUtils.Query();
			String sql = "select * from emp where id=" + id;
			return runner.query(sql, new BeanHandler<Emp>(Emp.class));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void upDate(Emp emp) {
		try {
			QueryRunner runner = DBUtils.Query();
			int id = emp.getId();
			String sql = "update emp set name=?,password=?,gender=?,age=?,hiredate=?salary=?,phone=?,emali=? where id=" + id;
			String name = emp.getName();
			String password = emp.getPassword();
			String gender = emp.getGender();
			Integer age = emp.getAge();
			Date hiredate = emp.getHiredate();
			double salary = emp.getSalary();
			String phone = emp.getPhone();
			String emali = emp.getEmali();
			runner.update(sql, name, password, gender, age, hiredate, salary, phone, emali);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(int id) {
		
		try {
			QueryRunner runner = DBUtils.Query();
			String sql="delete from emp where id="+id;
			runner.update(sql);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
