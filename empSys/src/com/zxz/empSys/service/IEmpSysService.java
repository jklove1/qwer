package com.zxz.empSys.service;

import java.util.List;

import com.zxz.empSys.domain.Emp;

/**
 * 服务接口
 * @author Administrator
 */
public interface IEmpSysService {
	
	/**
	 * 登录
	 * @param name
	 * @param password
	 * @return
	 */
	Emp findEmpByNmaeAndPassword(String name, String password);

	/**
	 * 显示所有数据
	 */
	List<Emp> findAll();

	/**
	 * 注册
	 * @param emp 
	 */
	void Add(Emp emp);

	/**
	 * 通过id找到对象
	 */
	Emp findById(int id);

	/**
	 * 通过id修改信息
	 */
	void upDate(Emp emp);

	/**
	 * 通过id删除数据
	 * @param id
	 */
	void deleteById(int id);


}
