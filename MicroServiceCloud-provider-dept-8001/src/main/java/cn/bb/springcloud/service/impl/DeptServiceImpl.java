package cn.bb.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.bb.entities.Dept;
import cn.bb.springcloud.dao.DeptDao;
import cn.bb.springcloud.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService{

	@Autowired
	DeptDao doclets;
	
	@Override
	public boolean addDept(Dept dept) {
		// TODO Auto-generated method stub
		return doclets.addDept(dept);
	}

	@Override
	public Dept findById(Long id) {
		// TODO Auto-generated method stub
		return doclets.findById(id);
	}

	@Override
	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		return doclets.findAll();
	}

}
