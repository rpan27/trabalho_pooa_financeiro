/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.model.dao;

import br.edu.vianna.financeiro.model.domain.Categoria;
import br.edu.vianna.financeiro.model.domain.Usuario;
import br.edu.vianna.financeiro.model.dto.CategoriaSelectDTO;
import br.edu.vianna.financeiro.model.dto.CategoriaViewDTO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author ronny
 */
public class CategoriaDAO extends GenericsDAO<Categoria, Integer> {

    @Override
    public Categoria inserir(Categoria obj) throws SQLException {
        conexao.getTransaction().begin();
        conexao.persist(obj);
        conexao.getTransaction().commit();
        return obj;
    }

    @Override
    public Categoria alterar(Categoria obj) throws SQLException {
        conexao.getTransaction().begin();
        conexao.merge(obj);
        conexao.getTransaction().commit();
        
        return obj;
    }

    @Override
    public void apagar(Integer key) throws SQLException {
        conexao.getTransaction().begin();
        Categoria categ = conexao.getReference(Categoria.class, key);
        conexao.remove(categ);
        conexao.getTransaction().commit();
    }
    public void apagarCategoria(Categoria obj) throws SQLException 
    {
        conexao.getTransaction().begin();
        conexao.remove(obj);
        conexao.getTransaction().commit();    
    }

    @Override
    public Categoria buscarUm(Integer key) throws SQLException {
        Query q = conexao.createQuery("SELECT u FROM Categoria u WHERE u.id = :id");

        try {
            q.setParameter("id", key);
            return (Categoria) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException ex) {
            return null;
        }
    }
        
    public List<CategoriaSelectDTO> buscarParaCombo() throws SQLException {
        Query q = conexao.createQuery("select new " + pkg +"CategoriaSelectDTO(c.id,c.descricao)"
                + "FROM Categoria c  ");

        return q.getResultList();
    }
    
    public List<CategoriaViewDTO> getSearchCategorias(String descricao) {
        Query q = conexao.createQuery("SELECT "
                + "new " + pkg + "CategoriaViewDTO(c.id, c.descricao) "                
                + "FROM Categoria c " 
                + " where c.descricao like :nome ");
                 
        
            q.setParameter("nome", "%"+descricao+"%");                
        
        return q.getResultList();
    }
    
    
    @Override
    public List<Categoria> buscarTodos() throws SQLException {
        Query q = conexao.createQuery("SELECT u FROM Categoria u ");

        try {          
            return (List<Categoria>) (Usuario) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException ex) {
            return null;
        }
    }    
}
