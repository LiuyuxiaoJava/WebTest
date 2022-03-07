package com.test.service;

import com.test.entity.Caipin;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Liuyuxiao
 * @version 1.0
 * @description: TODO
 * @date 2022/3/6 11:32
 */
public interface UserService {
    /**
     * 判断用户是否正确
     * @param username
     * @param password
     * @param request
     * @return
     * @throws SQLException
     */
    boolean isLogin(String username, String password, HttpServletRequest request) throws SQLException;

    List<Caipin> getAllCaipin() throws SQLException;

    boolean addCaipin(Caipin cp) throws SQLException;
}
