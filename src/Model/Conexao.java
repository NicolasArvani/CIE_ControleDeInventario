package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.*;

public class Conexao {
    private static final String jsonLocal = System.getenv("DATABASE_LP") + "/databaseCIE.json";

    public static Connection newConection(){
        System.out.println("Iniciando conexão com o banco de dados...");
        try{
            JsonObject dbJson = (JsonObject) JsonParser.parseReader(new FileReader(jsonLocal));
            Class.forName(dbJson.get("DRIVER").getAsString());
            return DriverManager.getConnection(dbJson.get("url").getAsString(), 
                                                dbJson.get("user").getAsString(), 
                                                dbJson.get("psw").getAsString());
        }catch(ClassNotFoundException | SQLException | FileNotFoundException e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    } 

    public static void closeConnection(Connection con){
        try{
            if(con != null){
                con.close();
            }
        }catch(SQLException e){
            System.out.println("Erro ao fechar conexão com o banco de dados: " + e.getMessage());
        }
    }

}
