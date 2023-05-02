package DAO;

import Model.Conexao;
import Model.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;



public class EnderecoDAO {

    // database: 
    // id; rua; bairro; cidade; estado; cep; numero;

    public static boolean inserir(Endereco endereco){
        PreparedStatement stmt;
        Connection con = Conexao.newConection();
        try{
            String sql = "INSERT INTO endereco(rua, bairro, cidade, estado, cep, numero) VALUES (?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getBairro());
            stmt.setString(3, endereco.getCidade());
            stmt.setString(4, endereco.getEstado());
            stmt.setString(5, endereco.getCep());
            stmt.setInt(6, endereco.getNumero());
            if(stmt.executeUpdate() > 0){
                con.commit();
                return true;
            }else{
                con.rollback();
                return false;
            }

        }catch(SQLException e){
            System.out.println("Erro ao excluir ativo: " + e.getMessage());
            return false;
        }finally{
            Conexao.closeConnection(con);
        }
    }

}
