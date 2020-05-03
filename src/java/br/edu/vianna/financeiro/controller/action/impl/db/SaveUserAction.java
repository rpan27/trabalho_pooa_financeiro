/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.controller.action.impl.db;

import br.edu.vianna.financeiro.controller.action.ICommanderAction;
import br.edu.vianna.financeiro.controller.action.impl.view.CallViewLoginAction;
import br.edu.vianna.financeiro.model.dao.UsuarioDAO;
import br.edu.vianna.financeiro.model.domain.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ronny
 */
public class SaveUserAction implements ICommanderAction{

    @Override
    public boolean ehLiberado() {
        return true;
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
            
        Usuario user = new Usuario(0,
                                    request.getParameter("cpNome"),
                                    request.getParameter("cpLogin"),
                                    request.getParameter("cpSenha"), false);
        
      user.setEmail(request.getParameter("cpEmail"));
      
      new UsuarioDAO().inserir(user);
      
      request.setAttribute("succ", "Usuário salvo com sucesso!!!");    
      new CallViewLoginAction().executar(request, response);        
    }    
}
