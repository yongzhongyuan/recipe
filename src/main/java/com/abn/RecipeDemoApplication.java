package com.abn;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Recipe demo API", version = "1.0", description = "Recipe Information"))
public class RecipeDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(RecipeDemoApplication.class, args);
	}
}