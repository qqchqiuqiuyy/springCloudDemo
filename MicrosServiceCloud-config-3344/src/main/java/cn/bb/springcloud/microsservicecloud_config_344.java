package cn.bb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import com.netflix.discovery.shared.Application;

@SpringBootApplication
@EnableConfigServer
public class microsservicecloud_config_344 {

	public static void main(String[] args) {

		SpringApplication.run(microsservicecloud_config_344.class, args);
	}

}
