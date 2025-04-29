package produto;

public class MaioresPrecos {
    public static void verificarPreco(double[] precos, String[] nomes) {
        double[] maiores = new double[3];
        String[] topNomes = new String[3];

        for (int i = 0; i < precos.length; i++) {
            if (precos[i] > maiores[0]) {
                maiores[2] = maiores[1];
                topNomes[2] = topNomes[1];
                maiores[1] = maiores[0];
                topNomes[1] = topNomes[0];
                maiores[0] = precos[i];
                topNomes[0] = nomes[i];
            } else if (precos[i] > maiores[1]) {
                maiores[2] = maiores[1];
                topNomes[2] = topNomes[1];
                maiores[1] = precos[i];
                topNomes[1] = nomes[i];
            } else if (precos[i] > maiores[2]) {
                maiores[2] = precos[i];
                topNomes[2] = nomes[i];
            }
        }

        System.out.println("Produtos com os maiores preços:");
        for (int i = 0; i < 3; i++) {
            if (topNomes[i] != null) {
                System.out.println(topNomes[i] + " - Preço: " + maiores[i]);
            }
        }
    }
}
