/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.controller.action.impl.db;

import br.edu.vianna.financeiro.controller.action.ICommanderAction;
import br.edu.vianna.financeiro.controller.action.impl.view.CallViewListaUsuarioAction;
import br.edu.vianna.financeiro.model.dao.UsuarioDAO;
import br.edu.vianna.financeiro.model.domain.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ronny
 */
public class SaveDeleteUsuarioAction implements ICommanderAction{

    @Override
    public boolean ehLiberado() {
        return false;
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        final UsuarioDAO usrDao = new UsuarioDAO();
        Usuario usr = usrDao.buscarUm(Integer.parseInt(request.getParameter("id")));
        usrDao.apagar(usr.getId());
        usrDao.close();
        request.setAttribute("succ", "Usuário apagado com sucesso!!!");
        new CallViewListaUsuarioAction().executar(request, response);
    }
    
}
