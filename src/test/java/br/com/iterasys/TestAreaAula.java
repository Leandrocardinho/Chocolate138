package br.com.iterasys;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAreaAula {

    @Test
    public void testarCaculcularQuadrado(){
        // Configura
        double lado = 3;
        double resultadoEsperado = 9;

        // Executa
        double resultadoAtual = AreasAula.calcularQuadrado(lado);

        //Valida
        assertEquals(resultadoAtual,resultadoEsperado);
    }

    @Test
    public void testarCaculcularRetangulo(){
        // Configura
        double largura = 3;
        double comprimento = 3;
        double resultadoEsperado = 9;

        // Executa
        double resultadoAtual = AreasAula.calcularRetangulo(largura, comprimento);

        //Valida
        assertEquals(resultadoAtual,resultadoEsperado);
    }
    @Test
    public void testarCaculcularTriangulo(){
        // Configura
        double base= 3;
        double altura =4;
        double resultadoEsperado = 6;

        // Executa
        double resultadoAtual = AreasAula.calcularTriangulo(base,altura);

        //Valida
        assertEquals(resultadoAtual,resultadoEsperado);
    }
    @Test
    public void testarCaculcularCirculo(){
        // Configura
        double raio =6;
        double resultadoEsperado = 113.09733552923255;

        // Executa
        double resultadoAtual = AreasAula.calcularCirculo(raio);

        //Valida
        assertEquals(resultadoAtual,resultadoEsperado);
    }
}
