package com.test.dao.impl;

import com.test.dao.UserDao;
import com.test.entity.Caipin;
import com.test.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Liuyuxiao
 * @version 1.0
 * @description: TODO
 * @date 2022/3/6 11:05
 */
public class UserDaoImpl implements UserDao {
    private  Caipin caipin=new Caipin();
    private QueryRunner queryRunner=new QueryRunner();
    @Override
    public Map<String, Object> isLogin(String name, String password) throws SQLException {
        return queryRunner.query(JdbcUtil.getConn(),"SELECT COUNT(*) num FROM users WHERE username='" + name + "' AND PASSWORD='" + password + "'",new MapHandler());
    }

    @Override
    public List<Caipin> getAllCaipin() throws SQLException {
        return queryRunner.query(JdbcUtil.getConn(),"select * from caipin",new BeanListHandler<>(Caipin.class));
    }

    @Override
    public int addCaipin(Caipin cp) throws SQLException {
        return queryRunner.update(JdbcUtil.getConn(),
                "INSERT INTO caipin SET caiName='" + cp.getCaiName() + "',kouwei='" + cp.getKouwei() + "',pic='"
                        + cp.getPic() + "',price=" + cp.getPrice() + ",miaoshu='" + cp.getMiaoshu() + "'");
    }
    @Override
    public int removeCaipin(int id) throws SQLException {
        return queryRunner.update(JdbcUtil.getConn(),"DELETE from caipin where id='"+id+"'");
    }

    @Override
    public int updateCaipin(int id) throws SQLException {
        return queryRunner.update(JdbcUtil.getConn(),"update caipin set caiName='"+caipin.getCaiName()+"',kouwei='"+caipin.getKouwei()+"'" +
                ",pic='"+caipin.getPic()+"',price='"+caipin.getPrice()+"',miaoshu='"+caipin.getMiaoshu()+"' where id='"+id+"'");
    }
}
