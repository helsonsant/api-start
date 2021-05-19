package br.com.bvs.upskilling;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SqlParser {
    public static void main(String[] args){
        String origem = "./sql/data-template.sql";
        String destino = "./sql/data.sql";
        String dataCorrente = getDataCorrente();
        try{
            FileWriter fileWriter = new FileWriter(destino);
            PrintWriter writer = new PrintWriter(fileWriter);

            File file  = new File(origem);
            BufferedReader read = new BufferedReader(new FileReader(file));

            String line;
            while ((line = read.readLine()) != null){
                writer.printf(line, dataCorrente);
            }
            writer.close();
            read.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static String getDataCorrente() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
