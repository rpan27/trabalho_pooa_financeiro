/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.controller.action.impl.view;

import br.edu.vianna.financeiro.controller.action.ICommanderAction;
import br.edu.vianna.financeiro.model.dao.DespesaDAO;
import br.edu.vianna.financeiro.model.dto.DespesaViewDTO;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ronny
 */
public class CallViewListaDespesaAction implements ICommanderAction{

    @Override
    public boolean ehLiberado() {
        return false;
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
           RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=lstDespesa");               
           List<DespesaViewDTO> despesas = new DespesaDAO().getSearchDespesas("", 0, 0);
           
           for(DespesaViewDTO item : despesas){
                item.setDataFormatada(item.getDataFormatada());
            }
           
           request.setAttribute("lista", despesas);
           
           rd.forward(request, response);
    }    
}
