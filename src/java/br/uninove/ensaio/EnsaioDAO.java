package br.uninove.ensaio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EnsaioDAO {
    private String msg;
    
    Ensaio selecionarPorId(int id){
        Conexao conexao = new Conexao();
        msg = conexao.consultar(String.format("Select * from App.Ensaio Where id = %d", id));
        if(msg.equals("Sucesso")){
            ResultSet r = conexao.getRetorno();            
            try{
                r.next();
                Ensaio ensaio = new Ensaio();
                ensaio.setId(r.getInt("id"));
                ensaio.setNome(r.getString("nome"));
                ensaio.setDtEnsaio(r.getDate("dtEnsaio"));
                ensaio.setValor(r.getBigDecimal("valor"));
                return ensaio;
            }catch(SQLException ex){
                msg = String.format("Problemas em consulta: %s", ex.getLocalizedMessage());
                return null;
            }
        }else{
            return null;
        }
    }
    
    List<Ensaio> selecionarTodos(){
        Conexao conexao = new Conexao();
        msg = conexao.consultar("Select * from App.Ensaio");
        if(msg.equals("Sucesso")){
            ResultSet r = conexao.getRetorno();
            try{
                List<Ensaio> lista = new ArrayList<>();
                while(r.next()){
                    Ensaio ensaio = new Ensaio();
                    ensaio.setId(r.getInt("id"));
                    ensaio.setNome(r.getString("nome"));
                    ensaio.setDtEnsaio(r.getDate("dtEnsaio"));
                    ensaio.setValor(r.getBigDecimal("valor"));
                    lista.add(ensaio);
                }
                return lista;
            }catch(SQLException ex){
                msg = String.format("Problemas em consulta: %s", ex.getLocalizedMessage());
                return null;
            }
        }else{
            return null;
        }
    }
    
    void inserir(Ensaio ensaio){
        Conexao conexao = new Conexao();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String sql = String.format(
            "Insert into App.Ensaio (nome, dtEnsaio, valor) "
            +"values ('%s', '%s', %d)", 
            ensaio.getNome(),
            formato.format(ensaio.getDtEnsaio()),
            ensaio.getValor().intValue()
        );
        msg = conexao.executar(sql);
    }
    
    void alterar(Ensaio ensaio){
        Conexao conexao = new Conexao();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String sql = String.format(
            "Update App.Ensaio set nome = '%s', dtEnsaio = '%s', valor = %d where id = %d",
            ensaio.getNome(),
            formato.format(ensaio.getDtEnsaio()),
            ensaio.getValor().intValue(),
            ensaio.getId()
        );
        msg = conexao.executar(sql);
    }
    
    void apagar(Ensaio ensaio){
        Conexao conexao = new Conexao();
        String sql = String.format("Delete from App.Ensaio where id = %d",
            ensaio.getId()
        );
        msg = conexao.executar(sql);
    }
    
    String getMsg(){
        return msg;
    }
}
