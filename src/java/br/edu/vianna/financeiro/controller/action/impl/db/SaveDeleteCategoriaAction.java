/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.controller.action.impl.db;

import br.edu.vianna.financeiro.controller.action.ICommanderAction;
import br.edu.vianna.financeiro.controller.action.impl.view.CallViewListaCategoriaAction;
import br.edu.vianna.financeiro.model.dao.CategoriaDAO;
import br.edu.vianna.financeiro.model.domain.Categoria;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ronny
 */
public class SaveDeleteCategoriaAction implements ICommanderAction{

    @Override
    public boolean ehLiberado() {
        return false;
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        final CategoriaDAO CategDao = new CategoriaDAO();
        Categoria categ = CategDao.buscarUm(Integer.parseInt(request.getParameter("id")));
        CategDao.apagar(categ.getId());
        CategDao.close();
        request.setAttribute("succ", "Categoria apagada com sucesso!!!");
        new CallViewListaCategoriaAction().executar(request, response);
    }
    
}
