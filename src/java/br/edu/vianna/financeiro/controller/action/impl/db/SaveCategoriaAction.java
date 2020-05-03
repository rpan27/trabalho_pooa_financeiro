/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.controller.action.impl.db;

import br.edu.vianna.financeiro.controller.action.ICommanderAction;
import br.edu.vianna.financeiro.controller.action.impl.view.CallViewHomeAction;
import br.edu.vianna.financeiro.model.dao.CategoriaDAO;
import br.edu.vianna.financeiro.model.domain.Categoria;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ronny
 */
public class SaveCategoriaAction implements ICommanderAction{

    @Override
    public boolean ehLiberado() {
        return false;
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Categoria categ = new Categoria(0, request.getParameter("cpDescricao") , request.getParameter("cpDetalhe") );
        
        new CategoriaDAO().inserir(categ);
        
        request.setAttribute("succ", "Categoria salva com sucesso!!!");
        new CallViewHomeAction().executar(request, response);
    }    
}
