package ex04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UnitAreas {
    // Atributos

    // Metodos e Funções
    // Uso Compatilhado( usar em varios testes)
    @DataProvider(name = "MassaAreaQuadrado") //DDT data driver
    public Object[][] massaAreaQuadrado(){
        return new Object[][]{
                { 3, 9 },
                { 2 , 4 },
                { 4 , 16},
                { 5 , 25}
        };
    }
    @DataProvider(name = "MassaAreaRetangulo")
    public Object[][] massaAreaRetangulo(){
        return new Object[][]{
                { 2, 10},
                { 3,  15 },
                { 5,  25},
                { 10 , 50},
                { 8, 40 }

        };
    }
    @DataProvider(name= "MassaAreaTriangulo")
    public Object[][] massaAreaTriagulo(){
        return new Object[][]{
                { 5, 25 },
                {6 , 30},
                {7 , 35},

        };
    }
    @DataProvider(name = "MassaAreaCirculo")
    public Object[][] massaAreaCirculo(){
        return new Object[][]{
            { 5, 78.5 },
            { 9, 254.34 },
            { 4, 50.24 }

        };
    }


    // Tests
    @Test(dataProvider = "MassaAreaQuadrado")
    public void testAreaQuadradoDD(double comprimento, double resultadoEsperado){

        //Configura /Arrange
        // Os dados vem atraves da Lista em @DataProvider


        //Executa  -Act
        double resultadoAtual = Areas.areaQuadrado(comprimento);

        // Valida -Assert
        assertEquals(resultadoAtual, resultadoEsperado);

    }
    @Test
    public void testAreaQuadrado(){

    //Configura Arrange
    double comprimento = 15;
    double resultadoEsperado = 225;

    //Executa  -Act
    double resultadoAtual = Areas.areaQuadrado(comprimento);

    // Valida -Assert
        assertEquals(resultadoAtual, resultadoEsperado);

    }


    @Test
    public void testAreaRetangulo(){
        //Configura - Arrange
        double comprimento = 7;
        // Lembrando que o valor da largura vem do codigo
        double resultadoEsperado = 35;

        // Executa - ACT
        double resultadoAtual = Areas.areaRetangulo(comprimento);

        // Valida - Assert
        assertEquals(resultadoAtual, resultadoEsperado);

    }
    @Test(dataProvider = "MassaAreaRetangulo")
    public void testAreaRetanguloDD(double comprimento, double resultadoEsperado){

        //Lembrando que a largura vem do codido que está em Areas

        // Executa - ACT
        double resultadoAtual = Areas.areaRetangulo(comprimento);

        // Valida - Assert
        assertEquals(resultadoAtual, resultadoEsperado);

    }
    @Test
    public void testAreaTriangulo(){
        // Configura -- Arrange
        double altura = 5;
        double resultadoEsperado = 25;

        // Executa - Act
        double resultadoAtual = Areas.areaTriangulo(altura);

        // Valida - Assert
        assertEquals(resultadoAtual,resultadoEsperado);
    }
    @Test(dataProvider = "MassaAreaTriangulo")
    public void testAreaTrianguloDD(double base, double resultadoEsperado){
        // Configura -- Arrang

        // Executa - Act
        double resultadoAtual = Areas.areaTriangulo(base);

        // Valida - Assert
        assertEquals(resultadoAtual,resultadoEsperado);
    }
    @Test
    public void testAreaCirculo(){
        // Configura - Arrange
        double raio = 5;
        double resultadoEsperado = 78.5;

        // Executa - Act
        double resultadoAtual = Areas.areaCirculo(raio);

        // Valida - Assert
        assertEquals(resultadoAtual,resultadoEsperado);
    }
    @Test(dataProvider = "MassaAreaCirculo")
    public void testAreaCirculoDD(double raio, double resultadoEsperado){
        // Configura - Arrange

        // Executa -Act
        double resultadoAtual = Areas.areaCirculo(raio);

        //Valida -Assert
        assertEquals(resultadoAtual,resultadoEsperado);
    }
}
