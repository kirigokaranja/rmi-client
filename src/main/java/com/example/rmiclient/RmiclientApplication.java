package com.example.rmiclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@SpringBootApplication
public class RmiclientApplication {

	@Bean
	RmiProxyFactoryBean rmiProxyFactoryBean(){
		RmiProxyFactoryBean bean = new RmiProxyFactoryBean();
		bean.setServiceInterface(Calculate.class);
		bean.setServiceUrl("rmi://localhost:1099/CalculateRMI");
		return bean;
	}

	public static void main(String[] args) {
		Calculate calculate = SpringApplication.run(RmiclientApplication.class, args).getBean(Calculate.class);
		System.out.println("<--------- Client Response ----------->");
		System.out.println(calculate.sum(5));
	}

}
