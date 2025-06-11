import java.io.IOException;

public class ShellSort {

  /*  O metodo é invocado atraves de chamada estatica passando a copia da referencia     |
  |  do vetor a ser ordenado como parametro, e esse parametro, fazendo com que o objeto  |
  |  vetor seja ordenado, devido a serem referencias ao mesmo objeto, não é necessario   |
  |  retornar nada, pois na proxima chamada do objeto, o mesmo já estara ordenado.       |
  |        Exmplo de chamada:  int vetor = ShellSort.ordenar(vetor);                    */

    public static void ordenar(int[] vet){
        int i , j , temp, size = vet.length;

        int incremento = 1;
        while(incremento < size) {
            incremento = 3 * incremento + 1;
        }

        while (incremento > 1) {
            incremento /= 3;

            for(i = incremento; i < size; i++) {
                temp = vet[i];
                j = i - incremento;
                while (j >= 0 && temp < vet[j]) {
                    vet[j + incremento] = vet[j];
                    j -= incremento;
                }
                vet [j + incremento] = temp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int quantidade = 1000000;
        int[] vetor = new int[quantidade];

        for (int i = 0; i < vetor.length/2; i++) {
            vetor[i] = (int) (i);
        }
        for (int i = vetor.length/2; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * i);
        }

        long tempoInicial = System.currentTimeMillis();

        ordenar(vetor);

        long tempoFinal = System.currentTimeMillis();

        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
    }
}
