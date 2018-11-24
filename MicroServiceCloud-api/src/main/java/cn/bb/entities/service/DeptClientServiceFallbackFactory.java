package cn.bb.entities.service;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bb.entities.Dept;
import feign.hystrix.FallbackFactory;
/*
 * 把DeptClientService 每个方法的熔断机制都放在这里
 * 和controller解耦
 */
@Component //!!!不能丢
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable arg0) {
		// TODO Auto-generated method stub
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dept get(long id) {
				// TODO Auto-generated method stub
				return new Dept().setDeptno(id)
				           .setDname("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
				           .setDb_source("no this database in MySQL");
			}
			
			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
