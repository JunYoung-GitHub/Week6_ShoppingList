/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 710429
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
         String action = (String) request.getParameter("action");
        if (action != null) {
            session.invalidate();
            session = request.getSession();
        }
        
        if(session.getAttribute("username") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);      
        }
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = (String) request.getParameter("action");
        ArrayList<String> addList = (ArrayList) session.getAttribute("addList");
        if(addList == null) {
            addList = new ArrayList<>();
        }
        String username = (String) request.getParameter("username");
        
        if(action.equals("register")) {
            if(username.equals("")) {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
            
            else
                session.setAttribute("username", username);
        }
        
        if(action.equals("add")) {
            String addItem = (String) request.getParameter("item");
            if(addItem.equals("")) {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
            
            else
                addList.add(addItem);
        }
        
        if(action.equals("delete")) {
            String deleteItem = request.getParameter("item");
            addList.remove(deleteItem);
        }
        
        session.setAttribute("addList", addList);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

}
