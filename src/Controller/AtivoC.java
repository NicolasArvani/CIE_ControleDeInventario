package Controller;

import DAO.AtivoDAO;
import Model.Ativo;
import Model.Endereco;

public class AtivoC {
    private Ativo ativo;

    public AtivoC(Ativo ativo) {
        this.ativo = ativo;
    }

    public AtivoC(String nome, double valor, boolean geradorDeReceita, Endereco endereco) {
        this.ativo = new Ativo(nome, valor, geradorDeReceita, endereco);
    }

    public String inserir(){
        return AtivoDAO.inserir(ativo) ? "Ativo inserido com sucesso!" : "Erro ao inserir ativo!";
    }

    public String atualizar(){
        return AtivoDAO.atualizar(ativo) ? "Ativo atualizado com sucesso!" : "Erro ao atualizar ativo!";
    }

    public String deletar(){
        return AtivoDAO.excluir(ativo) ? "Ativo deletado com sucesso!" : "Erro ao deletar ativo!";
    }

    


}
