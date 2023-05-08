package DAO;

import Model.Conexao;
import Model.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

//f endereco dao n precisa FUCKKKKKKKKKKKKKK

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
    
    public static boolean excluir(Endereco endereco){
        PreparedStatement stmt;
        Connection con = Conexao.newConection();
        try{
            String sql = "DELETE FROM endereco WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, endereco.getId());
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

    public static boolean atualizar(Endereco endereco){
        PreparedStatement stmt;
        Connection con = Conexao.newConection();
        try{
            String sql = "UPDATE endereco SET rua = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, numero = ? WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getBairro());
            stmt.setString(3, endereco.getCidade());
            stmt.setString(4, endereco.getEstado());
            stmt.setString(5, endereco.getCep());
            stmt.setInt(6, endereco.getNumero());
            stmt.setInt(7, endereco.getId());
            if(stmt.executeUpdate() > 0){
                con.commit();
                return true;
            }else{
                con.rollback();
                return false;
            }
        }catch(SQLException e){
            System.out.println("Erro ao atualizar ativo: " + e.getMessage());
            return false;
        }finally{
            Conexao.closeConnection(con);
        }
    }

    public static Endereco buscar(int id){
        PreparedStatement stmt;
        Connection con = Conexao.newConection();
        ResultSet rs;
        try{
            String sql = "SELECT * FROM endereco WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setCep(rs.getString("cep"));
                endereco.setNumero(rs.getInt("numero"));
                return endereco;
            }else{
                return null;
            }
        }catch(SQLException e){
            System.out.println("Erro ao buscar ativo: " + e.getMessage());
            return null;
        }finally{
            Conexao.closeConnection(con);
        }
    }


    public List<Endereco> listar(){
        Connection con = Conexao.newConection();
        PreparedStatement stmt;
        ResultSet rs;
        List<Endereco> enderecos = new ArrayList<>();
        try{
            String sql = "SELECT * FROM endereco";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setCep(rs.getString("cep"));
                endereco.setNumero(rs.getInt("numero"));
                enderecos.add(endereco);
            }
            return enderecos;
        }catch(SQLException e){
            System.out.println("Erro ao listar ativos: " + e.getMessage());
            return null;
        }finally{
            Conexao.closeConnection(con);
        }
    }
}
