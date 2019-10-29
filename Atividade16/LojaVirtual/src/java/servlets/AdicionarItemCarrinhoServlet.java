   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.CarrinhoCompraLocal;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 18114290034
 */
@WebServlet(name = "AdicionarItemCarrinhoServlet", urlPatterns = {"/carrinho/adicionar"})
public class AdicionarItemCarrinhoServlet extends HttpServlet {
    
    private CarrinhoCompraLocal carrinho;

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
            throws ServletException, IOException, NamingException {
        response.setContentType("text/html;charset=UTF-8");

        carrinho = (CarrinhoCompraLocal) request.getSession().getAttribute("ejb_stateful");

        if (carrinho == null) {
            try {
                Context contexto = new InitialContext();
                carrinho = (CarrinhoCompraLocal) contexto.lookup("java:global/Atividade16/CarrinhoEJB-ejb/CarrinhoCompraStateful!ejb.CarrinhoCompraLocal");
            } catch (NamingException e) {
                throw new ServletException(e);
            }
            request.getSession().setAttribute("ejb_stateful", carrinho);
        }
        
        String item = request.getParameter("item");
        carrinho.adicionarItem(item);

        List<String> lista = carrinho.listarItens();

        PrintWriter out = response.getWriter();
        
        if (lista.isEmpty()) {
            out.println("<p>Nenhum adicionado ao carrinho</p>");
        }

        for (String i : lista) {
            out.println("<p>" + i + "</p>");
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(AdicionarItemCarrinhoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(AdicionarItemCarrinhoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
