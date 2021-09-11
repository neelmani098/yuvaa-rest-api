package org.in.yuvaa.yuvaarestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class YuvaaRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(YuvaaRestApiApplication.class, args);
	}

}
