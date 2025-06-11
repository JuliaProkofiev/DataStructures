package Pilha;

public class ValidadorDeExpressoes {
    private static Pilha pilha;
    private static int MAX;

    public static boolean ValidadorDeExpressao(String expressao) {
        MAX = expressao.length();
        pilha = new Pilha(MAX);
        for(int i = 0; i < MAX; i++){
            char elemento_char = expressao.charAt(i);
            if(elemento_char == '(' || elemento_char == '{' || elemento_char == '['){
                pilha.insere(elemento_char);
            } else {
                if ((pilha.Topo() == '(' && elemento_char == ')') || (pilha.Topo() == '{' && elemento_char == '}') || (pilha.Topo() == '[' && elemento_char == ']')) {
                    pilha.remove();
                }
            }
        }
        return pilha.Vazia();
    }
//    public static void main(String[] args) throws IndexOutOfBoundsException{
//        if (ValidadorDeExpressao("(((1+2) - 3 )* 6)")) {
//            System.out.println("Expressão é invalida");
//        }
//        else { System.out.println("Expressão é valida"); }
//    }
}


