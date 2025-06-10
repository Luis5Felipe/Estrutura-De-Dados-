package structure;

import model.Produto;

public class ArvoreProduto {

    // Classe interna para representar um nó da árvore
    private static class No {
        Produto produto;
        No esquerda, direita;

        No(Produto produto) {
            this.produto = produto;
            this.esquerda = null;
            this.direita = null;
        }
    }

    private No raiz;

    public void inserir(Produto produto) {
        raiz = inserirRec(raiz, produto);
    }

    private No inserirRec(No atual, Produto produto) {
        // Se a árvore/subárvore estiver vazia, cria um novo nó
        if (atual == null) {
            return new No(produto);
        }

        // Navega para a esquerda se o ID for menor
        if (produto.getId() < atual.produto.getId()) {
            atual.esquerda = inserirRec(atual.esquerda, produto);
        // Navega para a direita se o ID for maior (ou igual)
        } else {
            atual.direita = inserirRec(atual.direita, produto);
        }

        return atual;
    }

    public Produto buscar(int id) {
        return buscarRec(raiz, id);
    }

    private Produto buscarRec(No atual, int id) {
        // Se o nó for nulo, o produto não existe
        if (atual == null) {
            return null;
        }

        // Se encontrou o ID, retorna o produto
        if (id == atual.produto.getId()) {
            return atual.produto;
        }

        // Decide se busca na subárvore esquerda ou direita
        return id < atual.produto.getId()
                ? buscarRec(atual.esquerda, id)
                : buscarRec(atual.direita, id);
    }

    public void listarEmOrdem() {
        System.out.println("\n--- Produtos em Ordem (ID crescente) ---");
        listarRec(raiz);
        System.out.println("----------------------------------------");
    }

    // Percorrendo em-ordem: esquerda -> raiz -> direita (resulta em lista ordenada)
    private void listarRec(No atual) {
        if (atual != null) {
            listarRec(atual.esquerda);
            System.out.println(atual.produto);
            listarRec(atual.direita);
        }
    }
}