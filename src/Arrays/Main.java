import java.util.Arrays;
public class Main
{
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numeros = new int[5];
        System.out.println("Digite o numero");
        for (int i = 0; i < 5; i++){
            numeros[i] = input.nextInt();
        }
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }
        System.out.println("Array ordenado com Bubble Sort:");
        for (int num : numeros) {
            System.out.println(num + " ");
        }
    }
}