package br.com.iterasys;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        public static void main(String[] args){

            System.out.println("Olá mundo!");
            chamarEncomenda();
            Calculadora.somarInteiros();
            Calculadora.subtrairInteiros();
            Calculadora.multiplicacao();
            Calculadora.divisao();
        }

            public static void chamarEncomenda(){
                int barras = 30;

                Encomenda.calculaBarrasDeChocolatePorCaixa(barras);
            }

}
