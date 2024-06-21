// 1 - Pacotes
package br.com.iterasys;

// 2 - Biblioteca

// 3- Classe
public class Encomenda {

    //Atributos

    // 3.2 Funções - Tem retorno tipo return
           //Metodos - void faz e acabou

    public static int calculaBarrasDeChocolatePorCaixa(int barras){
        int quatidadePorCaixa = 12;
        int caixas = barras / quatidadePorCaixa;
        int unidades = barras % quatidadePorCaixa;
        System.out.println("Quantidade de Caixas: " + caixas);
        System.out.println("Unidades " + unidades);
        return caixas;


    }


}
