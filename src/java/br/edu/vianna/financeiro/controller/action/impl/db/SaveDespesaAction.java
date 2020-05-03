/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.controller.action.impl.db;

import br.edu.vianna.financeiro.controller.action.ICommanderAction;
import br.edu.vianna.financeiro.controller.action.impl.view.CallViewHomeAction;
import br.edu.vianna.financeiro.model.dao.DespesaDAO;
import br.edu.vianna.financeiro.model.domain.Categoria;
import br.edu.vianna.financeiro.model.domain.Despesa;
import br.edu.vianna.financeiro.model.domain.Usuario;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ronny
 */
public class SaveDespesaAction implements ICommanderAction{

    @Override
    public boolean ehLiberado() {
        return false;
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        
        Calendar cal = GregorianCalendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String d = df.format(cal.getTime());
        Date d2 = df.parse(d);
        
        Despesa desp = new Despesa(0, Double.parseDouble(request.getParameter("cpValor")),
                                    request.getParameter("cpDescricao") ,
                                    new Date(),
                                    request.getParameter("cpObservacao"));
        
        desp.setCategoria(new Categoria(Integer.parseInt(request.getParameter("cpCategoria"))));
        desp.setUsuario(new Usuario(Integer.parseInt(request.getParameter("cpUsuario"))));
        
        new DespesaDAO().inserir(desp);
        
        request.setAttribute("succ", "Despesa salva com sucesso!!!");
        new CallViewHomeAction().executar(request, response);
    }    
}
