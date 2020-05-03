/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.financeiro.controller;

import br.edu.vianna.financeiro.controller.action.ICommanderAction;
import br.edu.vianna.financeiro.controller.action.impl.db.SaveCategoriaAction;
import br.edu.vianna.financeiro.controller.action.impl.db.SaveDeleteCategoriaAction;
import br.edu.vianna.financeiro.controller.action.impl.db.SaveDeleteDespesaAction;
import br.edu.vianna.financeiro.controller.action.impl.db.SaveDeleteUsuarioAction;
import br.edu.vianna.financeiro.controller.action.impl.db.SaveDespesaAction;
import br.edu.vianna.financeiro.controller.action.impl.db.SaveUserAction;
import br.edu.vianna.financeiro.controller.action.impl.login.CheckLoginAction;
import br.edu.vianna.financeiro.controller.action.impl.view.CallViewCadastreSeAction;
import br.edu.vianna.financeiro.controller.action.impl.view.CallViewCategoriaAction;
import br.edu.vianna.financeiro.controller.action.impl.view.CallViewDeleteCategoriaAction;
import br.edu.vianna.financeiro.controller.action.impl.view.CallViewDeleteDespesaAction;
import br.edu.vianna.financeiro.controller.action.impl.view.CallViewDeleteUsuarioAction;
import br.edu.vianna.financeiro.controller.action.impl.view.CallViewDespesaAction;
import br.edu.vianna.financeiro.controller.action.impl.view.CallViewEditDespesaAction;
import br.edu.vianna.financeiro.controller.action.impl.view.CallViewHomeAction;
import br.edu.vianna.financeiro.controller.action.impl.view.CallViewListaCategoriaAction;
import br.edu.vianna.financeiro.controller.action.impl.view.CallViewListaDespesaAction;
import br.edu.vianna.financeiro.controller.action.impl.view.CallViewListaUsuarioAction;
import br.edu.vianna.financeiro.controller.action.impl.view.CallViewLoginAction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ronny
 */
@WebServlet(name = "CommanderController", urlPatterns = {"/app"})
public class CommanderController extends HttpServlet {
    
    private static Hashtable <String, ICommanderAction> comandos;
    
    static{
            comandos = new Hashtable<>();
            comandos.put("login", new CallViewLoginAction());
            comandos.put("", new CallViewLoginAction());
            comandos.put("home", new CallViewHomeAction());
            comandos.put("cadastro", new CallViewCadastreSeAction());
            comandos.put("categoria", new CallViewCategoriaAction());
            comandos.put("despesa", new CallViewDespesaAction());
                    
            comandos.put("editDespesa", new CallViewEditDespesaAction());        
            
            comandos.put("delDespesa", new CallViewDeleteDespesaAction());                     
            comandos.put("delCategoria", new CallViewDeleteCategoriaAction());                     
            comandos.put("delUsuario", new CallViewDeleteUsuarioAction());                                 
            
            comandos.put("lstDespesa", new CallViewListaDespesaAction());
            comandos.put("lstCategoria", new CallViewListaCategoriaAction());
            comandos.put("lstUsuario", new CallViewListaUsuarioAction());                        
            
            comandos.put("saveUser", new SaveUserAction());
            comandos.put("saveCategoria", new SaveCategoriaAction()); 
            comandos.put("saveDespesa", new SaveDespesaAction());      
            
            //comandos.put("saveEditLivro", new SaveEditLivroAction());          
            comandos.put("saveDelDespesa", new SaveDeleteDespesaAction());        
            comandos.put("saveDelCategoria", new SaveDeleteCategoriaAction());        
            comandos.put("saveDelUsuario", new SaveDeleteUsuarioAction());        
            
            //comandos.put("pesqDespesa", new PesquisarDespesaAjaxAction());
            
            comandos.put("checkLogin", new CheckLoginAction());                        
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String ac = request.getParameter("ac");
        ac = ac == null? "" : ac;
        try {
            comandos.get(ac).executar(request, response);
        }catch (NullPointerException ex) {
            System.out.println(ex.getCause());
            RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=erro");        
            request.setAttribute("err", "Comando não encontrado!!!");
            rd.forward(request, response);
        }        
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=erro");        
            request.setAttribute("err", "Erro geral do sistema "+ex.getMessage());
            rd.forward(request, response);
        }          
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
