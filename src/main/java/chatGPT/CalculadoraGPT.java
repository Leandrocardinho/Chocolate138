package chatGPT;

public class CalculadoraGPT {

    //Metodo para adição

    public static double adicao(double a, double b){
        return a + b;

    }
    //Metodo subtração

    public static double subtracao (double a, double b){
        return a - b;

    }

    //Metodo para multiplicação
    public static double multiplicacao (double a, double b) {
        return a * b;

    }

    //Metodo para divisao

    public static double divisão (double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("ERRO divisão por zero não é permitida");
            return Double.NaN;
        }

    }
}
