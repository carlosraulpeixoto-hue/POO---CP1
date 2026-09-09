package br.com.fiapride.model;

/**
 * Representa um veiculo cadastrado na frota do FiapRide.
 *
 * Esta classe protege seu estado interno atraves de encapsulamento:
 * os atributos sao privados e so podem ser alterados atraves de
 * metodos que garantem que o veiculo nunca fique em um estado invalido
 * (ex: combustivel negativo).
 */
public class Veiculo {

    private String proprietario;
    private String placa;
    private double combustivel;

    /**
     * Cria um veiculo novo.
     *
     * @param proprietario nome do dono do veiculo (nao pode ser vazio)
     * @param placa placa do veiculo (nao pode ser vazia)
     * @param combustivelInicial quantidade inicial de combustivel (nao pode ser negativa)
     */
    public Veiculo(String proprietario, String placa, double combustivelInicial) {
        if (proprietario == null || proprietario.trim().isEmpty()) {
            throw new IllegalArgumentException("O proprietario nao pode ser vazio.");
        }
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("A placa nao pode ser vazia.");
        }
        if (combustivelInicial < 0) {
            throw new IllegalArgumentException("O combustivel inicial nao pode ser negativo.");
        }

        this.proprietario = proprietario;
        this.placa = placa;
        this.combustivel = combustivelInicial;
    }

    /**
     * Adiciona combustivel ao veiculo (abastecimento).
     *
     * @param quantidade quantidade a adicionar (deve ser maior que zero)
     */
    public void abastecer(double quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade a abastecer deve ser maior que zero.");
        }
        this.combustivel += quantidade;
    }

    /**
     * Consome combustivel do veiculo (uso em uma corrida, por exemplo).
     *
     * @param quantidade quantidade a consumir (deve ser maior que zero e nao pode
     *                    ultrapassar o combustivel disponivel)
     */
    public void consumirCombustivel(double quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade a consumir deve ser maior que zero.");
        }
        if (quantidade > this.combustivel) {
            throw new IllegalStateException(
                "Combustivel insuficiente. Disponivel: " + this.combustivel + ", solicitado: " + quantidade);
        }
        this.combustivel -= quantidade;
    }

    public String getProprietario() {
        return proprietario;
    }

    public String getPlaca() {
        return placa;
    }

    public double getCombustivel() {
        return combustivel;
    }

    @Override
    public String toString() {
        return "Dono: " + proprietario + " | Placa: " + placa + " | Gasolina: " + combustivel;
    }
}
