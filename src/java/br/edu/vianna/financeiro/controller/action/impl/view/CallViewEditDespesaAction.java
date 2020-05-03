/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.controller.action.impl.view;

import br.edu.vianna.financeiro.controller.action.ICommanderAction;
import br.edu.vianna.financeiro.model.dao.DespesaDAO;
import br.edu.vianna.financeiro.model.domain.Despesa;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ronny
 */
public class CallViewEditDespesaAction implements ICommanderAction{

    @Override
    public boolean ehLiberado() {
        return false;
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Despesa despesa = new DespesaDAO().buscarUm(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("desp", despesa);    
        new CallViewDespesaAction().executar(request, response);
    }    
}
