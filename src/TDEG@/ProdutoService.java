import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProdutoService {
    private final List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto novo) {
        produtos.add(novo);
        Collections.sort(produtos); // Garante que a lista esteja sempre ordenada por ID
    }

    public Produto buscarPorId(int id) {
        int inicio = 0;
        int fim = produtos.size() - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            Produto atual = produtos.get(meio);

            if (atual.getId() == id) {
                return atual; // Encontrado
            } else if (atual.getId() < id) {
                inicio = meio + 1; // Busca na metade direita
            } else {
                fim = meio - 1; // Busca na metade esquerda
            }
        }

        return null; // Não encontrado
    }

    public void listarProdutos() {
        System.out.println("\n--- Lista de Produtos ---");
        produtos.forEach(System.out::println);
        System.out.println("-------------------------");
    }
}