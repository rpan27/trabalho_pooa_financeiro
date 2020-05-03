/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.model.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author ronny
 */
@Entity
public class Usuario implements Serializable {        
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;       
    
    @Column(length = 80, nullable = false)
    private String nome;
    
    @Column(length = 80, nullable = false)
    private String email;
    
    @Column(length = 20, nullable = false, unique = true)
    private String login;    
    
    @Column(length = 20, nullable = false)
    private String senha;   
    
    private boolean ehAdministrador;
    
    @OneToMany(mappedBy = "usuario") 
    List<Despesa> despesas;    

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getEhAdministrador() {
        return ehAdministrador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }

    public void setEhAdministrador(boolean ehAdministrador) {
        this.ehAdministrador = ehAdministrador;
    }

    public Usuario() {
    }
    
    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(int id, String nome, String login, String senha, boolean ehAdministrador) {        
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.ehAdministrador = ehAdministrador;
    }                
}
