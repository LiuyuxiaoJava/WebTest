package com.test.servlet;

import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Liuyuxiao
 * @version 1.0
 * @description: TODO
 * @date 2022/3/7 13:31
 */
@WebServlet("/Remove")
public class RemoveServlet extends HttpServlet {
    private UserService service=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer userid = Integer.parseInt(req.getParameter("userid"));
            boolean flag = service.removeCaipin(userid);
            if (flag){
                System.out.println("Yes");
                resp.sendRedirect("ShowList");
            }
            else {
                System.out.println("NO");
                resp.sendRedirect("ShowList");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
