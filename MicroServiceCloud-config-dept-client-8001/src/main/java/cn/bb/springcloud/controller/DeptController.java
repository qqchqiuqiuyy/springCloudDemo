package cn.bb.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sun.tools.doclets.internal.toolkit.resources.doclets;

import cn.bb.entities.Dept;
import cn.bb.springcloud.service.DeptService;

@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	
	
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)  // 这个注解接收到的数据是Json就会映射到对象里面
	public boolean add(@RequestBody Dept dept){
		return deptService.addDept(dept);
	}

	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)  
	public Dept get(@PathVariable("id") Long id){
		return deptService.findById(id);
	}
	
	
	@RequestMapping(value="/dept/list",method=RequestMethod.GET)  
	public List<Dept> list(){
		return deptService.findAll();
	}
	
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}
	
	
	
	
	
	
}
