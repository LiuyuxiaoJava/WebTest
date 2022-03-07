package com.test.servlet;

import com.test.entity.Caipin;
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
 * @date 2022/3/7 0:26
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private UserService service=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path=req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/";
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            String caiName = req.getParameter("caiName");
            String kouwei = req.getParameter("kouwei");
            String pic = req.getParameter("pic");
            Float price = Float.parseFloat(req.getParameter("price"));
            String desc = req.getParameter("desc");
            Caipin caipin=new Caipin(null, caiName, kouwei, price, pic, desc);
            boolean flag = service.addCaipin(caipin);
            if (flag){
//                req.getRequestDispatcher("/ShowList");
                resp.sendRedirect("ShowList");
            }
            else{
                req.getRequestDispatcher("/WEB-INF/admin/add.jsp").forward(req,resp);
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
