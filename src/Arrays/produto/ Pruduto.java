package produto;

import java.util.Scanner;

public class Pruduto {
    private static double[] preco = new double[10];
    private static String[] nome = new String[10];
    public static void cadastrarProduto() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Nome do produto:");
            nome[i] = input.nextLine();
            System.out.println("Preço do produto:");
            preco[i] = input.nextDouble();
            input.nextLine();
        }
        MaioresPrecos.verificarPreco(preco,nome);
        input.close();
    }
}
