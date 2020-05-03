/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.model.dto;

/**
 *
 * @author ronny
 */
public class UsuarioViewDTO {
    private int id;
    private String nome;
    private String email;
    private boolean ehAdministrador;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEhAdministrador() {
        return ehAdministrador;
    }

    public void setEhAdministrador(boolean ehAdministrador) {
        this.ehAdministrador = ehAdministrador;
    }

    public UsuarioViewDTO() {
    }

    public UsuarioViewDTO(int id, String nome, String email, boolean ehAdministrador) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.ehAdministrador = ehAdministrador;
    }
    
    
}
