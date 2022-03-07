package com.test.dao;

import com.test.entity.Caipin;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Liuyuxiao
 * @version 1.0
 * @description: TODO
 * @date 2022/3/6 11:01
 */
public interface UserDao {
    /**
     *
     * @param name
     * @param password
     * @return
     */
    Map<String, Object> isLogin(String name,String password) throws SQLException;

    /**
     * 获取整个菜品
     * @return
     */
    List<Caipin> getAllCaipin() throws SQLException;

    /**
     * 添加菜品
     * @param cp
     * @return
     */
    int addCaipin(Caipin cp) throws SQLException;

    /**
     * 根据id删除商品
     * @param id
     * @return
     */
    int removeCaipin(int id) throws SQLException;

    /**
     * 根据id修改商品
     * @param id
     * @return
     */
    int updateCaipin(int id) throws SQLException;
}
