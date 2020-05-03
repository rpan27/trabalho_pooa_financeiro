/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.controller.action.impl.view;

import br.edu.vianna.financeiro.controller.action.ICommanderAction;
import br.edu.vianna.financeiro.model.dao.UsuarioDAO;
import br.edu.vianna.financeiro.model.domain.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ronny
 */
public class CallViewDeleteUsuarioAction implements ICommanderAction{

    @Override
    public boolean ehLiberado() {
        return false;
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Usuario usr = new UsuarioDAO().buscarUm(Integer.parseInt(request.getParameter("id")));

        response.getWriter().print("<div class=\"panel panel-default\" id=\"msgDel\">\n"
                + "  <div class=\"panel-heading\">Apagar?</div>\n"
                + "  <div class=\"panel-body\">Deseja apagar o usuário " + usr.getNome()+ "?</div>\n"
                + "<a href=\"app?ac=saveDelUsuario&id="+usr.getId()+"\" class=\"btn btn-primary btn-lg\" role=\"button\" aria-disabled=\"true\">Sim</a>\n"
                + "<a href=\"#\" id=\"btnNao\" class=\"btn btn-secondary btn-lg\" role=\"button\" aria-disabled=\"true\">Não</a>\n"
                + "</div>\n"
                + "<script>\n"
                + "$('#btnNao').on('click',function(){\n"
                + "   $('#msgDel').remove();\n"
                + "});\n"
                + "</script>\n");        
    }
    
}
