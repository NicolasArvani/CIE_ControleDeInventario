package Model;

public class Ativo {
    private int id;
    private String nome;
    private double valor;
    private boolean geradorDeReceita;
    private Endereco endereco;

    public Ativo(){  
    }

    public Ativo(int id, String nome, double valor, boolean geradorDeReceita, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.geradorDeReceita = geradorDeReceita;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isGeradorDeReceita() {
        return geradorDeReceita;
    }

    public void setGeradorDeReceita(boolean geradorDeReceita) {
        this.geradorDeReceita = geradorDeReceita;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    



}
