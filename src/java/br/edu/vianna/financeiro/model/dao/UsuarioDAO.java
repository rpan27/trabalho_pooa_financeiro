/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.model.dao;

import br.edu.vianna.financeiro.model.domain.Usuario;
import br.edu.vianna.financeiro.model.dto.UsuarioLoginDTO;
import br.edu.vianna.financeiro.model.dto.UsuarioSelectDTO;
import br.edu.vianna.financeiro.model.dto.UsuarioViewDTO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author ronny
 */
public class UsuarioDAO extends GenericsDAO<Usuario, Integer>{

    @Override
    public Usuario inserir(Usuario obj) throws SQLException {
        conexao.getTransaction().begin();
        conexao.persist(obj);
        conexao.getTransaction().commit();
        return obj;
    }

    @Override
    public Usuario alterar(Usuario obj) throws SQLException {
        conexao.getTransaction().begin();
        conexao.merge(obj);
        conexao.getTransaction().commit();
        
        return obj;
    }

    @Override
    public void apagar(Integer key) throws SQLException {        
        conexao.getTransaction().begin();
        Usuario usr = conexao.getReference(Usuario.class, key);
        conexao.remove(usr);
        conexao.getTransaction().commit();
    }

    @Override
    public Usuario buscarUm(Integer key) throws SQLException {
        Query q = conexao.createQuery("SELECT u FROM Usuario u WHERE u.id = :id");

        try {
            q.setParameter("id", key);
            return (Usuario) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException ex) {
            return null;
        }
    }

    @Override
    public List<Usuario> buscarTodos() throws SQLException {
            Query q = conexao.createQuery("SELECT u FROM Usuario u");
        try {        
            return (List<Usuario>) (Usuario) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException ex) {
            return null;
        }
    }
    
    public List<UsuarioSelectDTO> buscarParaCombo() throws SQLException {
        Query q = conexao.createQuery("select new " + pkg +"UsuarioSelectDTO(u.id,u.nome,u.ehAdministrador)"
                + "FROM Usuario u  ");

        return q.getResultList();
    }
    
    public List<UsuarioViewDTO> getSearchUsuarios(String nome) {
        Query q = conexao.createQuery("SELECT "
                + "new " + pkg + "UsuarioViewDTO(u.id, u.nome,u.email,u.ehAdministrador) "                
                + "FROM Usuario u " 
                + " where u.nome like :nome ");
                 
                 q.setParameter("nome", "%"+nome+"%");                
        
        return q.getResultList();
    }
    

        public UsuarioLoginDTO buscarPeloLoginaESenha(String login, String senha) throws SQLException {        
      
        Query q = conexao.createQuery("SELECT u FROM Usuario u "
                + "WHERE u.login = :log and u.senha = :sen");

        try {
            q.setParameter("log", login);
            q.setParameter("sen", senha);
            
            Usuario user = (Usuario) q.getSingleResult();
            
            UsuarioLoginDTO udto = new UsuarioLoginDTO(user.getId(), user.getLogin(), user.getEhAdministrador());
            
            return udto;
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException ex) {
            return null;
        }        
    }    
}
