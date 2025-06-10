import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoService service = new ProdutoService();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("""

                    === Menu Produtos (Busca Binária) ===
                    1 - Adicionar produto
                    2 - Buscar por ID
                    3 - Listar produtos
                    0 - Sair
                    """);
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("ID do produto: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // Consome a quebra de linha pendente
                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();
                    System.out.print("Preço do produto: ");
                    double preco = sc.nextDouble();
                    service.adicionarProduto(new Produto(id, nome, preco));
                    System.out.println("Produto adicionado com sucesso!");
                }
                case 2 -> {
                    System.out.print("Digite o ID para buscar: ");
                    int idBusca = sc.nextInt();
                    Produto encontrado = service.buscarPorId(idBusca);
                    if (encontrado != null) {
                        System.out.println("\nProduto encontrado: " + encontrado);
                    } else {
                        System.out.println("\nProduto com ID " + idBusca + " não encontrado.");
                    }
                }
                case 3 -> service.listarProdutos();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}