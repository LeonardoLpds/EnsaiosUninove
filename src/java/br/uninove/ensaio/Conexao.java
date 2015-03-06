package br.uninove.ensaio;

import java.sql.*;

public class Conexao {
    private Connection conexao;
    private Statement expressao;
    private ResultSet retorno;
    
    String conectar(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/Ensaios", "leonardo", "123456");
            return "Sucesso";
        }catch(ClassNotFoundException ex){
            return "Driver não localizado";
        }catch(SQLException ex){
            return "Falha ao conectar";
        }
    }
    
    String executar(String sql){
        String msg = conectar();
        if(msg.equals("Sucesso")){
            try{
                expressao = conexao.createStatement();
            }catch(SQLException ex){
                desconectar();
                return String.format("Impossivel gerar expressão SQL: %s", sql);
            }
            try{
                expressao.executeUpdate(sql);
                return msg;
            }catch(SQLException ex){
                desconectar();
                return String.format("Falha na execução de: '%s'", sql);
            }
        }
        else{
            return msg;
        }
    }
    
    String consultar(String sql){
        String msg = conectar();
        if(msg.equals("Sucesso")){
            try{
                expressao = conexao.createStatement();
            }catch(SQLException ex){
                desconectar();
                return String.format("Impossivel gerar expressão SQL: %s", sql);
            }
            try{
                retorno = expressao.executeQuery(sql);
                return msg;
            }catch(SQLException ex){
                return String.format("Falha na consulta '%s'", sql);
            }
        }else{
            return msg;
        }
    }
    
    void desconectar(){
        try{
            if(retorno != null){
                retorno.close();
            }
        }catch(SQLException ex){
        }finally{
            try{
                if (expressao != null) {
                    expressao.close();
                }
            }catch(SQLException ex){
            }finally{
                try{
                    if(conexao != null){
                        conexao.close();
                    }
                }catch(SQLException ex){
                }
            }
        }
    }
    
    ResultSet getRetorno(){
        return retorno;
    }
    
}
