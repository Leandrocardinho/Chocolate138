package juntos;


public class Calculadora2Test {



    public static int somarInteiros(int num1, int num2) {
        int soma = num1 + num2;
        System.out.println("Soma de " + num1 + " + " + num2 + ": " + soma);
        return soma;
    }

    public static int subtrairInteiros(int num1, int num2) {
        int resultado = num1 - num2;
        System.out.println("A subtração de " + num1 + " - " + num2 + ": " + resultado);
        return resultado;
    }

    public static int multiplicacao(int num1, int num2) {
        int resultado = num1 * num2;
        System.out.println("A multiplicação de " + num1 + " * " + num2 + ": " + resultado);
        return resultado;
    }


    public static int divisao(int num1, int num2) {
        if (num2 != 0) {
            int resultado = num1 / num2;
            System.out.println("A divisão de " + num1 + " / " + num2 + ": " + resultado);
            return resultado;
        } else {
            System.out.println("Não é possível dividir por zero");
            return 0;
        }
    }

    public static void main(String[] args) {
        // Testando os métodos
        somarInteiros(5, 7);
        subtrairInteiros(7, 5);
        multiplicacao(2, 2);
        divisao(2, 2);
        divisao(2, 0); // Teste de divisão por zero
    }

}