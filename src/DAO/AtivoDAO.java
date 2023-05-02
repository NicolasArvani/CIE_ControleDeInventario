package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import Model.Ativo;
import Model.Conexao;

public class AtivoDAO {    

    public static boolean inserir(Ativo ativo){
        Connection con = Conexao.newConection();
        PreparedStatement stmt;
        try{
            String sql = "INSERT INTO ativo (nome, valor, geradorDeReceita, endereco_id) VALUES (?, ?, ?, ?)";
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, ativo.getNome());
            stmt.setDouble(2, ativo.getValor());
            stmt.setBoolean(3, ativo.isGeradorDeReceita());
            stmt.setInt(4, ativo.getEndereco().getId());
            if(stmt.executeUpdate() > 0){
                con.commit();
                return true;
            }else{
                con.rollback();
                return false;
            }
        }catch(SQLException e){
            System.out.println("Erro ao inserir ativo: " + e.getMessage());
            return false;
        }finally{
            Conexao.closeConnection(con);
        }
    }

    public static boolean atualizar(Ativo ativo){
        Connection con = Conexao.newConection();
        PreparedStatement stmt;
        try{
            String sql = "UPDATE ativo SET nome = ?, valor = ?, geradorDeReceita = ?, endereco_id = ? WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, ativo.getNome());
            stmt.setDouble(2, ativo.getValor());
            stmt.setBoolean(3, ativo.isGeradorDeReceita());
            stmt.setInt(4, ativo.getEndereco().getId());
            stmt.setInt(5, ativo.getId());
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

    public static boolean excluir(Ativo ativo){
        Connection con = Conexao.newConection();
        PreparedStatement stmt;
        try{
            String sql = "DELETE FROM ativo WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, ativo.getId());
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


    public static List<Ativo> listar(){
        Connection con = Conexao.newConection(); 
        try{
            String sql = "SELECT * FROM ativo ORDER BY id";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Ativo> ativos = new ArrayList<>();
            while(rs.next()){
                ativos.add(new Ativo(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDouble("valor"),
                    rs.getBoolean("geradorDeReceita"),
                    //EnderecoDAO.buscar(rs.getInt("endereco_id")) //Criar método buscar em EnderecoDAO
                    null
                ));
            }
            return ativos;
        }catch(SQLException e){
            System.out.println("Erro ao listar ativos: " + e.getMessage());
            return null;
        }finally{
            Conexao.closeConnection(con);
        }
    }

}
