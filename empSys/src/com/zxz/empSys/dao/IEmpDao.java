package com.zxz.empSys.dao;

import java.util.List;

import com.zxz.empSys.domain.Emp;
/**
 * dao接口
 * @author Administrator
 *
 */
public interface IEmpDao {
		
	/**
	 * 通过name和password查找员工
	 * @param name
	 * @param psaaword
	 * @return
	 */
	Emp findEmpByNmaeAndPassword(String name,String password);

	/**
	 * 显示所有数据
	 */
	List<Emp> findAll();

	/**
	 * 添加数据
	 */
	void Add(Emp emp);

	/**
	 * 通过id找到实体对象
	 * @param id
	 * @return
	 */
	Emp findById(int id);

	/**
	 * 通过id修改对象信息
	 * @param id
	 */
	void upDate(Emp emp);

	/**
	 * 通过id删除信息
	 * @param id
	 */
	void deleteById(int id);
}
