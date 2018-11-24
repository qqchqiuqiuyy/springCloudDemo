package cn.bb.entities.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bb.entities.Dept;


		//表示为这个微服务进行面向接口的feign编码              和 出现错误后去哪个类处理熔断

@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

	  @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
	  public Dept get(@PathVariable("id") long id);

	  @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
	  public List<Dept> list();

	  @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
	  public boolean add(Dept dept);
	
}
