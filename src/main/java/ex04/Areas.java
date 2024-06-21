package ex04;



public class Areas {


    public static double areaQuadrado(double comprimento ) {
        double area = comprimento * comprimento; // Calculo da area
        System.out.println("A area do quadrado com o comprimento " + comprimento + " é: " + area);
        return area;
    }


    public static double areaRetangulo(double comprimento ) {
         double largura = 5;
        double area = comprimento * largura;
        System.out.println("A area do retangulo com comprimento " + comprimento + " e largura " + largura + " é: " + area);
        return area;
    }

    public static double areaTriangulo(double base) {
        double altura = 10;
        double area = (base * altura) / 2;
        System.out.println("A area do triangulo com base " + base + " e altura " + altura + " é : " + area);
        return area;
    }

    public static double areaCirculo(double raio) {
        double area = 3.14 * raio * raio;
        System.out.println("A area do circulo com o raio " + raio + " é: " + area);
        return area;

    }



}
