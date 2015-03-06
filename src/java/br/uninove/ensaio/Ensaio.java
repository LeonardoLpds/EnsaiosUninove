package br.uninove.ensaio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Ensaio implements Serializable{
    
    private int id;
    private String nome;
    private Date dtEnsaio;    
    private BigDecimal valor;

    public Ensaio() {
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }


    public Date getDtEnsaio() {
        return dtEnsaio;
    }

    public void setDtEnsaio(Date dtEnsaio) {
        this.dtEnsaio = dtEnsaio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
