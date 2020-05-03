/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ronny
 */
public class DespesaViewDTO {
    private int id;
    private String descricao;
    private Date data;
    private double valor;
    private boolean foiPaga = false;
    private String dataFormatada;

    public String getDataFormatada() {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate= DateFor.format(data);
        return stringDate;
    }

    public void setDataFormatada(String dataFormatada) {
        this.dataFormatada = dataFormatada;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean getFoiPaga() {
        return foiPaga;
    }

    public void setFoiPaga(boolean foiPaga) {
        this.foiPaga = foiPaga;
    }

    public DespesaViewDTO() {
    }

    public DespesaViewDTO(int id, String descricao, Date data, double valor,boolean foiPaga) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.foiPaga = foiPaga;
    }   
    
}
