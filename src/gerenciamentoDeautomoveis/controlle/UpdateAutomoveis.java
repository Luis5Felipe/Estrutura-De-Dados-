package controlle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateAutomoveis {
    private static final File ARQUIVO = new File("automoveis.txt");
    private static Scanner input = new Scanner(System.in);
    public static void removerCarro(){
        System.out.println("Digite a placa do carro: ");
        String placa = input.nextLine();

        List<String> linhasRestantes = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;

            while ((linha = bufferedReader.readLine()) != null) {
                if (!linha.trim().equalsIgnoreCase(placa.trim())) {
                    linhasRestantes.add(linha);
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (String l : linhasRestantes) {
                writer.write(l);
                writer.newLine();
            }
            System.out.println("Linha com a placa " + placa + "removida com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
