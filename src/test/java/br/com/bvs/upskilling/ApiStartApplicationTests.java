package br.com.bvs.upskilling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class ApiStartApplicationTests {
	String origem = "./sql/data.sql";

	@Test
	public void dadaUmaData_whenProcessadoArquivoTemplate_entaoDataInjetadaNoTemplate() {
		try{
			File file = new File(origem);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String linha;
			while ((linha = reader.readLine()) != null){
				System.out.println("Testando... --> " + linha);
				Assertions.assertTrue(linha.indexOf(this.getDataCorrente()) > 0, "Data corrente não localizada!");
			}
			reader.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public String getDataCorrente(){
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
}
