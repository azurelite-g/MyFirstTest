package com.example.jsp_demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(name = "Logout-Servlet" ,value = "/logout")
public class LogoutServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        HttpSession session = req.getSession(false);
        if (session != null){
            session.invalidate();
            

        }
        res.sendRedirect("login.html");
    }
}
