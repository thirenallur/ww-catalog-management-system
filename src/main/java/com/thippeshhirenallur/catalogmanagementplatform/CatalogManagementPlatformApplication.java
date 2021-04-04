package com.thippeshhirenallur.catalogmanagementplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing 
public class CatalogManagementPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogManagementPlatformApplication.class, args);
	}

}
