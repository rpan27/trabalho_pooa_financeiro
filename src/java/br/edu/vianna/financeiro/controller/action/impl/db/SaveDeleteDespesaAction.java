/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.controller.action.impl.db;

import br.edu.vianna.financeiro.controller.action.ICommanderAction;
import br.edu.vianna.financeiro.controller.action.impl.view.CallViewListaDespesaAction;
import br.edu.vianna.financeiro.model.dao.DespesaDAO;
import br.edu.vianna.financeiro.model.domain.Despesa;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ronny
 */
public class SaveDeleteDespesaAction implements ICommanderAction{

    @Override
    public boolean ehLiberado() {
        return false;
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        final DespesaDAO DespDao = new DespesaDAO();
        Despesa desp = DespDao.buscarUm(Integer.parseInt(request.getParameter("id")));
        DespDao.apagar(desp.getId());
        DespDao.close();
        request.setAttribute("succ", "Despesa apagada com sucesso!!!");
        new CallViewListaDespesaAction().executar(request, response);
    }
    
}
