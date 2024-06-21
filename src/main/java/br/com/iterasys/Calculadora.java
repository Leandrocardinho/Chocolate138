package br.com.iterasys;

public class Calculadora {

    public static int somarInteiros() {
        int num1 = 5;
        int num2 = 7;
        int resultado = num1 + num2;
        System.out.println("Soma de " + num1 + " + " + num2 + ": " + resultado);
        return resultado;
    }

    public static int subtrairInteiros() {
        int num1 = 7;
        int num2 = 5;
        int resultado = num1 - num2;
        System.out.println("A subtração de " + num1 + " - " + num2 + ": " + resultado);
        return resultado;
    }

    public static int multiplicacao() {
        int num1 = 2;
        int num2 = 2;
        int resultado = num1 * num2;
        System.out.println("A multiplicação de " + num1 + " * " + num2 + ": " + resultado);
        return resultado;
    }

    public static int divisao() {
        int num1 = 2;
        int num2 = 2;

        if (num2 != 0) {
            int resultado = num1 / num2;
            System.out.println("A divisão de " + num1 + " / " + num2 + ": " + resultado);
            return resultado;
        } else {
            System.out.println("Não é possivel dividir por zero");
            return 0;
        }
    }
}
