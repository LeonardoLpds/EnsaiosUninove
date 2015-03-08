package br.uninove.ensaio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class EnsaioService {
    private String msg;
    private EnsaioDAO dao;
    final Date dataMinima;
    final Date dataMaxima;
    
    public EnsaioService(){
        dataMinima = new Date(1);
        dataMaxima = new Date();
    }
    
    public String getMsg(){
        return msg;
    }
    
    public Ensaio selecionarPorId(int id){
        dao = new EnsaioDAO();
        Ensaio ensaio = dao.selecionarPorId(id);
        msg = dao.getMsg();
        return ensaio;
    }
    
    public List<Ensaio> selecionarTodos(){
        dao = new EnsaioDAO();
        List<Ensaio> lista = dao.selecionarTodos();
        msg = dao.getMsg();
        return lista;
    }
    
    public void inserir(String nome, Date dtEnsaio, BigDecimal valor){
        dao = new EnsaioDAO();
        if(nome == null){
            nome = "";
        }
        if(!nome.equals("")){
            if(nome.trim().length() > 50){
                nome = nome.trim().substring(0, 50);
            }
            if(dtEnsaio.getTime() >= dataMinima.getTime()){
                if(dtEnsaio.getTime() <= dataMaxima.getTime()){
                    if(valor.compareTo(BigDecimal.ZERO) > 0){
                        if(valor.compareTo(BigDecimal.valueOf(100000)) < 0){
                            Ensaio ensaio = new Ensaio();
                            ensaio.setId(0);
                            ensaio.setNome(nome);
                            ensaio.setDtEnsaio(dtEnsaio);
                            ensaio.setValor(valor);
                            dao.inserir(ensaio);
                            msg = dao.getMsg();
                        }else{
                            msg = "Valor alto de mais";
                        }
                    }else{
                        msg = "valor deve ser positivo";
                    }
                }else{
                    msg = "Data deve estar no passado";
                }
            }else{
                msg = "Data deve ser superior a 1/jan/1970";
            }
        }else{
            msg = "Nome precisa ser informado";
        }
    }
    public void alterar(int id, String nome, Date dtEnsaio, BigDecimal valor){
        dao = new EnsaioDAO();
        if(nome == null){
            nome = "";
        }
        if(!nome.equals("")){
            if(nome.trim().length() > 50){
                nome = nome.trim().substring(0, 50);
            }
            if(dtEnsaio.getTime() >= dataMinima.getTime()){
                if(dtEnsaio.getTime() <= dataMaxima.getTime()){
                    if(valor.compareTo(BigDecimal.ZERO) > 0){
                        if(valor.compareTo(BigDecimal.valueOf(100000)) < 0){
                            Ensaio ensaio = new Ensaio();
                            ensaio.setId(id);
                            ensaio.setNome(nome);
                            ensaio.setDtEnsaio(dtEnsaio);
                            ensaio.setValor(valor);
                            dao.alterar(ensaio);
                            msg = dao.getMsg();
                        }else{
                            msg = "Valor alto de mais";
                        }
                    }else{
                        msg = "valor deve ser positivo";
                    }
                }else{
                    msg = "Data deve estar no passado";
                }
            }else{
                msg = "Data deve ser superior a 1/jan/1970";
            }
        }else{
            msg = "Nome precisa ser informado";
        }
    }
    
    public void apagar(int id){
        dao = new EnsaioDAO();
        Ensaio ensaio = new Ensaio();
        ensaio.setId(id);
        ensaio.setNome("");
        ensaio.setDtEnsaio(new Date());
        ensaio.setValor(BigDecimal.ZERO);
        dao.apagar(ensaio);
        msg = dao.getMsg();
    }
}
