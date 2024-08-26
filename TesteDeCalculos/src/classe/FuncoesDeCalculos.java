package classe;

public class FuncoesDeCalculos {
    /*public static int Soma(int a, int b){
        return a+b;
    }
    public static int Subtracao(int a, int b){
        return a-b;
    }
    public static int Multiplicacao(int a, int b){
        return a*b;
    }
    public static int Divisao(int a, int b){
        return a/b;
    }*/
    public static int funcoesDeCalculos(String metodo, int x, int y) {
        if (metodo == "+"){
            return x + y;
        }
        else if (metodo == "-"){
            return x - y;
        }
        else if (metodo == "*") {
            return x * y;
        }
        else {
            return x / y;
        }

    }
}
