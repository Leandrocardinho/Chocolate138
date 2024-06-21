// Pacote
package juntos;
// 2 - Biblioteca

import juntos.Calculadora2Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

// 3 - Classe
public class UnitCalculadora2 {

    //  3.1 - Atributos

    // 3.2 - Métodis e Funções
    // 3.2 Metodos e funções

    // 3.3 Uso Compartilhado
    @DataProvider(name = "MassaMultiplicar") //isso sera mais lista massa de tests DATADRIVEN
    public Object[][] massaMultiplicar(){
        return new Object[][]{
                { 5, 7, 35 }, // dois primeiros valores são de entrada, o ultimo é o resultado
                { 2, 10, 20 },
                { 20, 0, 0 },
                {10, 10, 100 }, // dois primeiros valores são de entrada, o ultimo é o resultado
                { 5, 5, 25 }
        };
    }
    @DataProvider(name = "MassaDividir") //isso sera mais lista massa de testes
    public Object[][] massaDividir(){
        return new Object[][]{
                { 6, 2, 3 }, // dois primeiros valores são de entrada, o ultimo é o resultado
                { 10, 5, 2 },
                { 20, 10, 2 }
        };
    }

    //Testes
    @Test
    public void testSomar(){
        //Configura - Arrange
        int num1 =5;
        int num2 = 7;
        int resultadoEsperado = 12; //Resultado da conta num1 + num2

        // Executa - act
        int resultadoAtual = Calculadora2Test.somarInteiros(num1, num2);

        // Validade - Assert
        assertEquals(resultadoAtual,resultadoEsperado);
    }
    @Test
    public void testSubtrair(){
        //Configura --Arrange
        int num1 = 10;
        int num2 = 5;

        int resultadoEsperado =  5;

        // Executa -act
       int resultadoAtual = Calculadora2Test.subtrairInteiros(num1,num2);

        //Validade -Arrange
        assertEquals(resultadoAtual,resultadoEsperado);
    }
    @Test
    public void testMultiplicar(){
        //Configura -Arrange
        int num1 = 5;
        int num2 = 7;
        int resultadoEsperado = 35;

        //Executa -Act

        int resultadoAtual = Calculadora2Test.multiplicacao(num1,num2);

        //Valida -Arrange
        assertEquals(resultadoAtual,resultadoEsperado);
    }
    @Test(dataProvider = "MassaMultiplicar")
    public void testMultiplicarDD(int num1, int num2, int resultadoEsperado){
        //Configura -Arrange
        //Os dados são fornecidos para o teste atraves de uma lista em dataProvider

        //Executa -Act

        int resultadoAtual = Calculadora2Test.multiplicacao(num1,num2);

        //Valida -Arrange
        assertEquals(resultadoAtual,resultadoEsperado);
    }
    @Test
    public void testDividir(){
        //Configura -Arrange
        int num1 = 8;
        int num2 = 2;
        int resultadoEsperado = 4;

        //Executa -Act

        int resultadoAtual = Calculadora2Test.divisao(num1,num2);

        //Valida -Arrange
        assertEquals(resultadoAtual,resultadoEsperado);
    }
    @Test(dataProvider = "MassaDividir")
    public void testDividirDD(int num1, int num2, int resultadoEsperado){
        //Configura -Arrange
        //OS dados vem da lista


        //Executa -Act

        int resultadoAtual = Calculadora2Test.divisao(num1,num2);

        //Valida -Arrange
        assertEquals(resultadoAtual,resultadoEsperado);
    }

}

