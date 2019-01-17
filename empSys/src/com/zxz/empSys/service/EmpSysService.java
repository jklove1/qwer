package com.zxz.empSys.service;

import java.util.List;

import com.zxz.empSys.dao.EmpDao;
import com.zxz.empSys.dao.IEmpDao;
import com.zxz.empSys.domain.Emp;
/**
 * 服务实现类
 * @author Administrator
 *
 */
public class EmpSysService implements IEmpSysService {
	
	IEmpDao dao=new EmpDao();

	@Override
	public Emp findEmpByNmaeAndPassword(String name, String password) {
		return dao.findEmpByNmaeAndPassword(name,password);
	}

	@Override
	public List<Emp> findAll() {
		return dao.findAll();
	}

	@Override
	public void Add(Emp emp) {
		dao.Add(emp);
	}

	@Override
	public Emp findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void upDate(Emp emp) {
		dao.upDate(emp);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
	}

}
