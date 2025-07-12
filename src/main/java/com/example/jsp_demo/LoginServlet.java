package com.example.jsp_demo;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import com.example.jsp_demo.DAOImple.UserDAOImple;
import com.example.jsp_demo.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet",value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("doGet");

         String username=req.getParameter("user");
         String pass=req.getParameter("password");
        UserDAOImple userDAO=new UserDAOImple();
        User user=userDAO.login(username,pass);
        if(user!=null){
            System.out.println("Login Success");
            HttpSession session=req.getSession();
            session.setAttribute("user",user.getUsername());
            res.sendRedirect("welcome.jsp");
        }
         else {
             System.out.println("Login Failed");
             req.setAttribute("error","用户名或密码错误");
             req.getRequestDispatcher("login.html").forward(req,res);
         }
    }
}
