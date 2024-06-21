package juntos;

public class TestCalculadora2{
    public static void main(String[] args) {

        System.out.println("Olá mundo!");

        // Chamadas para os métodos da Calculadora2 com parâmetros
        Calculadora2Test.somarInteiros(5, 7);
        Calculadora2Test.subtrairInteiros(7, 5);
        Calculadora2Test.multiplicacao(2, 3);
        Calculadora2Test.divisao(8, 2);
        Calculadora2Test.divisao(2, 0); // Teste de divisão por zero
    }
}
