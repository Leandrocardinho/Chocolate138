package chatGPT;

public class TestCalculadora {


    public static void main(String[] args) {
        double a = 20; // Valor pré-definido para num1
        double b = 10;  // Valor pré-definido para num2

        System.out.println("Adição: " + CalculadoraGPT.adicao(a , b));
        System.out.println("Subtração: " + CalculadoraGPT.subtracao (a ,b));
        System.out.println("Multiplicação: " + CalculadoraGPT.multiplicacao(a , b));
        System.out.println("Divisão: " + CalculadoraGPT.divisão(a , b));
    }
}
