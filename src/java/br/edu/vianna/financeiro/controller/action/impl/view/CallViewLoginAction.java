/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.controller.action.impl.view;

import br.edu.vianna.financeiro.controller.action.ICommanderAction;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ronny
 */
public class CallViewLoginAction implements ICommanderAction{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=login");
        rd.forward(request, response);
    }    

    @Override
    public boolean ehLiberado() {
        return true;
    }
}
