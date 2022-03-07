package com.test.servlet;

import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Liuyuxiao
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    private UserService service=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = request.getScheme() + "://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
        System.out.println("路径是：=》  "+basePath);
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            request.getSession().setAttribute("username",username);
            Cookie cookie = new Cookie("user", username);
            cookie.setMaxAge(24*3600);
            response.addCookie(cookie);
            Boolean flag=service.isLogin(username,password,request);
            if (flag){
                //登录成功
//                request.getRequestDispatcher("/WEB-INF/admin/main.jsp").forward(request,response);
                request.getRequestDispatcher("/ShowList").forward(request,response);
            }
            else {
                //登录失败
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
//        response.getWriter().println("<h1>Hello</h1>");
    }
}
