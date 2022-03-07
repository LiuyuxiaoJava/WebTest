package com.test.service.impl;

import com.test.dao.UserDao;
import com.test.dao.impl.UserDaoImpl;
import com.test.entity.Caipin;
import com.test.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Liuyuxiao
 * @version 1.0
 * @description: TODO
 * @date 2022/3/6 11:34
 */
public class UserServiceImpl implements UserService {
    private UserDao user=new UserDaoImpl();
    @Override
    public boolean isLogin(String username, String password, HttpServletRequest request) throws SQLException {
        //在后台做限制
        String pattern = "[a-zA-Z]{3,12}";
        boolean flag = username.matches(pattern);
//        request.setAttribute("errorMsg", "*用户名或者密码格式不争取");
        if (flag) {// username满足格式要求
            // 2、查询数据库，看username、password是否存在
            Map<String, Object> map = user.isLogin(username, password);
            // 3、如果存在则跳转到success.jsp，否则跳转到fail.jsp
            Object obj = map.get("num");
            int num = Integer.parseInt(obj.toString());
            if (num <= 0) {// username格式完全正确，但是数据库不存在
//                request.setAttribute("errorMsg", "*用户名或者密码不正确");
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public List<Caipin> getAllCaipin() throws SQLException {
        return user.getAllCaipin();
    }

    @Override
    public boolean addCaipin(Caipin cp) throws SQLException {
        int i = user.addCaipin(cp);
        if (i>-1){
            return true;
        }
        return false;
    }
}
