package br.com.easymoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EasyMoneyLoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyMoneyLoanApplication.class, args);
	}

}
