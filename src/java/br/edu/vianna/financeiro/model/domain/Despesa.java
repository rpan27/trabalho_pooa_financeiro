/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.model.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author ronny
 */
@Entity
public class Despesa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private double valor;
    
    @Column(length = 20, nullable = false)
    private String descricao;
    
    @Column(nullable = false, columnDefinition = "DATE")
    private Date dataDespesa;
    
    private boolean foiPaga = false;
    
    @Column(nullable = true,columnDefinition = "TEXT")
    private String observacao;
            
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

   
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Despesa() {
    }
    
    public Despesa(int id) {
        this.id = id;
    }
    
    public Despesa(int id, double valor, String descricao, Date dataDespesa, String observacao, Categoria categoria, Usuario usuario) {
           this.id = id;
           this.valor = valor;
           this.descricao = descricao;
           this.dataDespesa = dataDespesa;
           this.observacao = observacao;
           this.categoria = categoria;
           this.usuario = usuario;
       }

    public Despesa(int id, double valor, String descricao, Date dataDespesa, String observacao) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.dataDespesa = dataDespesa;
        this.observacao = observacao;        
    }
    

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(Date dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    public boolean isFoiPaga() {
        return foiPaga;
    }

    public void setFoiPaga(boolean foiPaga) {
        this.foiPaga = foiPaga;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }    
}
