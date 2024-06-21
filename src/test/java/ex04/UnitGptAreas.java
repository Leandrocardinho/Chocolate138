package ex04;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UnitGptAreas {


    @Test
    public void testAreaQuadrado() {
        double comprimento = 5.0;
        double resultadoEsperado = 25.0;
        double resultadoAtual = Areas.areaQuadrado(comprimento);
        assertEquals(resultadoEsperado, resultadoAtual, 0.0001);
    }

    @Test
    public void testAreaRetangulo() {
        double comprimento = 10;
        double resultadoEsperado = 50.0;
        double resultadoAtual = Areas.areaRetangulo(comprimento);
        assertEquals(resultadoEsperado, resultadoAtual, 0.0001);
    }

    @Test
    public void testAreaTriangulo() {
        double base = 25.0;
        double altura = 10.0;
        double resultadoEsperado = 0.5 * base * altura;
        double resultadoAtual = Areas.areaTriangulo(base);
        assertEquals(resultadoEsperado, resultadoAtual, 0.0001);
    }

    @Test
    public void testAreaCirculo() {
        double raio = 2.0;
        double resultadoEsperado = 3.14 * raio * raio;
        double resultadoAtual = Areas.areaCirculo(raio);
        assertEquals(resultadoEsperado, resultadoAtual, 0.0001);
    }
}

