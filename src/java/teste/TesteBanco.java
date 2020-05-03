/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.edu.vianna.financeiro.model.dao.CategoriaDAO;
import br.edu.vianna.financeiro.model.dao.UsuarioDAO;
import br.edu.vianna.financeiro.model.domain.Categoria;
import br.edu.vianna.financeiro.model.domain.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ronny
 */
public class TesteBanco {
    
        public static void main(String[] args) {
            
            /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FinanceiroPU");
        
        EntityManager em = emf.createEntityManager();
        
        System.out.println("Connectou");
        
        em.getTransaction().begin();
        
        em.persist( new Categoria(0, "Àgua", null) );
        em.persist( new Categoria(0, "Luz", null) );
        em.persist( new Categoria(0, "Internet", null) );
        em.persist( new Categoria(0, "Supermercado", null) );
        em.persist( new Categoria(0, "Almoço", null) );
        em.persist( new Categoria(0, "Mensalidade Faculdade", null) );
        em.persist( new Categoria(0, "Fatura Cartão de Crédito", null) );

        
        em.getTransaction().commit();
        
        em.close();
        emf.close();*/
        try {
            
                UsuarioDAO usuariodao = new UsuarioDAO();
                usuariodao.inserir( new Usuario(Integer.MIN_VALUE,"admin", "admin", "123", true));
                /*
                CategoriaDAO categDAO = new CategoriaDAO();
                categDAO.inserir(new Categoria(0, "Àgua"));
                Categoria c1 = categDAO.buscarUm(1);                
                System.out.println(c1.getDescricao());
                c1.setDetalhe("Conta de Água");
                categDAO.alterar(c1);
                
                categDAO.apagar(1);
                categDAO.apagarCategoria(c1);
                
                c1 = categDAO.buscarUm(1);                
                System.out.println(c1.getDescricao());
                */
                //categDAO.close();
        } catch (Exception e) {
            
        }        
    }    
}
