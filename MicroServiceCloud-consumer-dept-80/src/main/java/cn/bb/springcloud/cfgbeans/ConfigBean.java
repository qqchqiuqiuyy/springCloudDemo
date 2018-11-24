package cn.bb.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration //相当于applicationContext.xml
public class ConfigBean {
	
	@Bean
	@LoadBalanced//开启负载均衡 主要靠这个RestTemplate负责客户端的操作
	public RestTemplate geRestTemplate(){
		return new RestTemplate();
	}
	@Bean  //更改负载循环轮换方式 默认是轮着顺序
	public IRule myRule(){
		return new RandomRule();//这里是随机
	}
	
	
}
//@Bean
//public UserServices getUserService(){
//	return UserServiceImpl();
//}
