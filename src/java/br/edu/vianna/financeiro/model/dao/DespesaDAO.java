/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.model.dao;

import br.edu.vianna.financeiro.model.domain.Categoria;
import br.edu.vianna.financeiro.model.domain.Despesa;
import br.edu.vianna.financeiro.model.dto.DespesaViewDTO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author ronny
 */
public class DespesaDAO extends GenericsDAO<Despesa, Integer>  {

    @Override
    public Despesa inserir(Despesa obj) throws SQLException {
        conexao.getTransaction().begin();
        conexao.persist(obj);
        conexao.getTransaction().commit();
        return obj;
    }

    @Override
    public Despesa alterar(Despesa obj) throws SQLException {
        conexao.getTransaction().begin();
        conexao.merge(obj);
        conexao.getTransaction().commit();
        
        return obj;
    }

    @Override
    public void apagar(Integer key) throws SQLException {
        conexao.getTransaction().begin();
        Despesa desp = conexao.getReference(Despesa.class, key);
        conexao.remove(desp);
        conexao.getTransaction().commit();
    }

    @Override
    public Despesa buscarUm(Integer key) throws SQLException {
        Query q = conexao.createQuery("SELECT u FROM Despesa u WHERE u.id = :id");
        try {
            q.setParameter("id", key);
            return (Despesa) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException ex) {
            return null;
        }
    }
        
    public Double buscarTotalDespesaUsuario(int idUsuario) throws SQLException {
        Query q = conexao.createQuery("SELECT sum(u.valor) FROM Despesa u WHERE u.id = :id");
        try {
            q.setParameter("id", idUsuario);
            return (Double) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException ex) {
            return null;
        }
    }

    @Override
    public List<Despesa> buscarTodos() throws SQLException {
        Query q = conexao.createQuery("SELECT u FROM Despesa u");
        try {        
            return (List<Despesa>) (Despesa) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException ex) {
            return null;
        }
    }   
    
        public List<DespesaViewDTO> getSearchDespesas(String descricao, int categoria, int usuario) {

        Query q = conexao.createQuery("SELECT "
                + "new " + pkg + "DespesaViewDTO(d.id, d.descricao, d.dataDespesa, d.valor,d.foiPaga) "                
                + "FROM Despesa d ");
                        
                        
             //   + " where d.descricao like :nome "
             //   + "and (l.idCategoria.id = :idCate OR -1 = :idCate)");        
        if(descricao != "")
            q.setParameter("nome", "%"+descricao+"%");
        if(categoria > 0)
            q.setParameter("idCate", categoria);
        if(usuario > 0)
            q.setParameter("idUsuario", usuario);
        
        
        return q.getResultList();

    }
}
