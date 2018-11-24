package cn.bb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import cn.bb.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient//说明这个是客户端
@RibbonClient(name="MICROSERVICECLOUD-DEPT", configuration=MySelfRule.class)
public class DeptConsumer80_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}
