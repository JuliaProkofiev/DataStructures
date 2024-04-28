public class BuscaBinaria {
    private static int[] Dados;
    private static int count;

    private static void busca_binaria(int[] dados, int x, int inicio, int fim) {
        int found = 0;
        Dados = dados;
        if (inicio == fim) {
            if (Dados[inicio] == x) {
                found = inicio;
                System.out.println(x + " encontrado na posição: " + found);
            } else {
                System.out.println(x + " Não foi encontrado");
            }
        } else {
            if (Ordenado()) {
                int meio = (fim + inicio) / 2;
                for (int g = inicio; g <= meio; g++) {
                    if ((Dados[g]) != x) {
                        if (g == meio) {
                            if (g + 1 == fim && Dados[fim] != x) {
                                System.out.println("Não há " + x + " nessa lista");
                                break;
                            }
                            if((g + 1) == fim && Dados[fim] == x) {
                                found = g+1;
                                System.out.println(x + " encontrado na posição: " + found);
                                break;
                            }else {
                                busca_binaria(Dados, x, meio, fim);
                                break;
                            }
                        }
                    } else {
                        found = g;
                        System.out.println(x + " encontrado na posição: " + found);
                        break;
                    }
                }
            } else {
                System.out.println("A Lista não está ordenada! Favor revise-a");
            }
        }
    }

    private static boolean Ordenado(){
        boolean ordenado = false;
        if(Dados.length-1 == 0){
            ordenado = true;
        }else {
            for (int g = 0; g < Dados.length; g++) {
                if(count != Dados.length-1) {
                    if (Dados[g] < Dados[g + 1]) {
                        count++;
                    } else {
                        if (Dados[g] > Dados[g + 1]) {
                            ordenado = false;
                            break;
                        }
                    }
                }else{
                    ordenado = true;
                }
            }
        }
        return ordenado;
    }

   // public static void main(String[] args){
       // int[] dados = new int[]{0, 1, 2, 3, 4, 5};
      //  busca_binaria(dados,5,0,6);
    //}
}

