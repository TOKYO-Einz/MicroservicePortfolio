package com.SolRodri.gatewayparcial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayParcialApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayParcialApplication.class, args);
	}

}
