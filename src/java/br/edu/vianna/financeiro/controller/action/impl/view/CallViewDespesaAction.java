/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.controller.action.impl.view;

import br.edu.vianna.financeiro.controller.action.ICommanderAction;
import br.edu.vianna.financeiro.model.dao.CategoriaDAO;
import br.edu.vianna.financeiro.model.dao.UsuarioDAO;
import br.edu.vianna.financeiro.model.dto.CategoriaSelectDTO;
import br.edu.vianna.financeiro.model.dto.UsuarioSelectDTO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ronny
 */
public class CallViewDespesaAction implements ICommanderAction{

    @Override
    public boolean ehLiberado() {
        return false;
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=frmdespesa");
        List<CategoriaSelectDTO> allCategorias = new CategoriaDAO().buscarParaCombo();        
        List<UsuarioSelectDTO> allUsuarios = new UsuarioDAO().buscarParaCombo();
        
        request.setAttribute("categorias", allCategorias);
        request.setAttribute("usuarios", allUsuarios);
                
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dataAtual = df.format(new Date());
                                    
        request.setAttribute("dataAtual", new Date());
        
        rd.forward(request, response);    
        
        //new CallViewHomeAction().executar(request, response);
    }
    
}
