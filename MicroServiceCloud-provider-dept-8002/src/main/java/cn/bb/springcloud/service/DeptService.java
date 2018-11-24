package cn.bb.springcloud.service;

import java.util.List;

import cn.bb.entities.Dept;



public interface DeptService {
	public boolean addDept(Dept dept);
	 
	  public Dept findById(Long id);
	 
	  public List<Dept> findAll();
}
