package br.com.fiapride.main;

import br.com.fiapride.model.Veiculo;

public class SistemaPrincipal {

    public static void main(String[] args) {

        // O construtor ja impede que o veiculo nasca com dados invalidos
        // (nao e mais possivel criar um veiculo com combustivel negativo)
        Veiculo v1 = new Veiculo("Carlos", "ABC-1234", 0);

        v1.abastecer(50);
        System.out.println(v1);

        // Tentativa de consumir mais do que o disponivel agora e barrada
        // pela propria classe, em vez de deixar o dado ficar inconsistente.
        try {
            v1.consumirCombustivel(100);
        } catch (IllegalStateException e) {
            System.out.println("Operacao bloqueada: " + e.getMessage());
        }

        // Consumo valido
        v1.consumirCombustivel(20);
        System.out.println(v1);
    }
}
