package com.example.jsp_demo;

import com.example.jsp_demo.DAOImple.UserDAOImple;
import com.example.jsp_demo.Model.Result;
import com.example.jsp_demo.Model.User;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet",value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // resp.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
        //resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        //resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println("RegisterServlet");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        StringBuilder json=new StringBuilder();
        try(BufferedReader reader=req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        }
        User user = gson.fromJson(json.toString(), User.class);
        try {
            UserDAOImple userDAO = new UserDAOImple();
            int userid = userDAO.Register(user);
            resp.getWriter().write(gson.toJson(new Result("success","",userid)));

        }catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().write(gson.toJson(new Result("error","数据库出现错误",-1)));

        }
    }

//    @Override
//    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       // resp.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
////        System.out.println("RegisterServlet-doOptions");
////        resp.setHeader("Access-Control-Allow-Origin", "*");
////        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
//////        System.out.println("RegisterServlet");
////        resp.setContentType("application/json");
////        resp.setCharacterEncoding("UTF-8");
//
//        resp.setHeader("Access-Control-Allow-Origin", "*");
//        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        resp.setHeader("Access-Control-Max-Age", "3600");
//        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
//
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        System.out.println("RegisterServlet-get");
        // Hello
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "nihao" + "</h1>");
        out.println("</body></html>");
    }
}
