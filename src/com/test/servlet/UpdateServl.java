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
 * @date 2022/3/7 17:29
 */
@WebServlet("/Update")
public class UpdateServl extends HttpServlet {
    private UserService service=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            Integer userid = Integer.parseInt(req.getParameter("userid"));
            String caiName = req.getParameter("caiName");
            String kouwei = req.getParameter("kouwei");
            String pic = req.getParameter("pic");
            Float price = Float.parseFloat(req.getParameter("price")==null? String.valueOf(0) :req.getParameter("price"));
            String desc = req.getParameter("desc");
            Caipin caipin=new Caipin(Long.parseLong(String.valueOf(userid)), caiName, kouwei, price, pic, desc);
            boolean flag = service.updateCaipin(userid);
            if (flag){
                System.out.println("🆗");
                resp.sendRedirect("ShowList");
            }
            else {
                System.out.println("№");
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
