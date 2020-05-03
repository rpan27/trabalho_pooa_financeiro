/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.model.dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ronny
 */
public abstract class GenericsDAO<C, K> {    
    protected static final String pkg = "br.edu.vianna.financeiro.model.dto.";
    protected static EntityManager conexao;
    private static EntityManagerFactory emf;
    
    public GenericsDAO() {
        getConexao();
    }

    public void close() {
        if (conexao.isOpen()) {
            conexao.close();
            emf.close();
        }
    }

    public EntityManager getConexao() {
        if (this.conexao == null || !this.conexao.isOpen()) 
        {
            this.emf = Persistence.createEntityManagerFactory("FinanceiroPU");
            conexao = emf.createEntityManager();
        }
        return conexao;
    }
        
    public abstract C inserir(C obj) throws SQLException ;
    public abstract C alterar(C obj) throws SQLException ;
    public abstract void apagar(K key) throws SQLException ;
    
    public abstract C buscarUm(K key) throws SQLException ;
    public abstract List<C> buscarTodos() throws SQLException;        
}
