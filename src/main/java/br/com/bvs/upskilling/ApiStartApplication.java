package br.com.bvs.upskilling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableAutoConfiguration
@RestController
@Slf4j
public class ApiStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiStartApplication.class, args);
	}
	
	@GetMapping(value = "/bvs-health/{nome}", produces = "application/json")
	public ResponseEntity<String> getHealthStatus(@PathVariable String nome) {
		String msg = String.format("{\"status\" : \"UP\", \"nome\": \"%s\"}", nome);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@GetMapping(value = "/bvs-health-xml", produces = "application/xml")
	public ResponseEntity<String> getHealthStatusXml() {
		return new ResponseEntity<String>("<xml><status>UP</status></xml>", HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/relatorio", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> postRelaorio(@RequestBody SolicitacaoRelatorio objetoRelatorio){
		log.info("[ACRT][01] Entrada no serviço: {}", objetoRelatorio.toString());
		String msg = String.format("{\"relatorioGerado\" : \"%s\"}", objetoRelatorio.getModeloRelatorio());
		log.info("[ACRT][02] Serviço executado com sucesso!");
		return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);
	}
}

@Data
class SolicitacaoRelatorio {
	private String nome;
	private String modeloRelatorio;
}
