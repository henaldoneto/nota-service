package br.com.arquivei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NotaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotaServiceApplication.class, args);
	}

}
