package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SalvarAutomoveis {
    private static final File ARQUIVO = new File("automoveis.txt");

    public static void salvarAutomoveis(Automovel automovel) {
        try (FileWriter fileWriter = new FileWriter(ARQUIVO, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            String linha = automovel.getPlaca() + " " +
                    automovel.getModelo() + " " +
                    automovel.getMarca() + " " +
                    automovel.getAno() + " " +
                    automovel.getValor();

            bufferedWriter.write(linha);
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
