package com.example.jsp_demo.DAOImple;

import com.example.jsp_demo.DAO.UserDAO;
import com.example.jsp_demo.Model.User;

import java.sql.*;
import java.util.PrimitiveIterator;

public class UserDAOImple implements UserDAO {
    private static final String DB_URL = "jdbc:mysql://mysql2.sqlpub.com:3307/py_test";
    private static final String DB_USER = "azurelite";
    private static final String DB_PASSWORD = "o1Sxg2tXyRNmt8DG";

    public int Register(User user) throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("DB Register User");
        String sql = "insert into web_users(username,password,email) values(?,?,?)";
        try(Connection connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            PreparedStatement ps=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getEmail());
            ps.executeUpdate();
            try (ResultSet rs=ps.getGeneratedKeys()) {
                if(rs.next()) return rs.getInt(1);
            }
        }
        return 0;
    }

    @Override
    public User login(String username, String password) {
        System.out.println("login-hanshu");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "select * from cloud where user = ? and password = ?";
        try {
            Connection connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                System.out.println("登录成功");
                User user = new User();
                user.setUsername(resultSet.getString("user"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
            else {
                System.out.println("登录失败，用户名或者密码错误");
                return null;
            }
        }catch (Exception e){
            System.out.println("操作失败");
            e.printStackTrace();
            return null;
        }
    }
}
