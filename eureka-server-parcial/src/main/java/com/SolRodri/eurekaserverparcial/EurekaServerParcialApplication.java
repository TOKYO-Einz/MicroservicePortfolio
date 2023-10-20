package com.SolRodri.eurekaserverparcial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerParcialApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerParcialApplication.class, args);
	}

}
