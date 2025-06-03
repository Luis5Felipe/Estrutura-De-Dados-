package controlle;

import model.Automovel;
import model.SalvarAutomoveis;

import java.util.Scanner;

public class CadastroDeAutomovel {
    public static void cadastro() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a placa do automovel");
        String placa = input.nextLine();

        System.out.println("Digite o modelo do automovel");
        String modelo = input.nextLine();

        System.out.println("Digite a marca do automovel");
        String marca = input.nextLine();

        System.out.println("Digite o ano do automovel");
        int ano = input.nextInt();

        System.out.println("Digite o valor do automovel");
        double valor = input.nextDouble();

        Automovel automovel = new Automovel(placa, modelo, marca, ano, valor);
        SalvarAutomoveis.salvarAutomoveis(automovel);
    }
}
