/*
 * Aplicação Exemplo
 */
package br.com.bvs.upskilling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class ApiStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiStartApplication.class, args);
	}
	
	@GetMapping(value = "/bvs-health", produces = "application/json")
	public ResponseEntity<String> getHealthStatus() {
		String msg = String.format("{\"status\" : \"UP\"}");
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
