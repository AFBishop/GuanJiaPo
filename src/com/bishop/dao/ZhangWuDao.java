package com.bishop.dao;

import com.bishop.domain.ZhangWu;
import com.bishop.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ZhangWuDao {
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
    public void addZhangWu(ZhangWu zw){
        try {
            String sql = "INSERT  INTO gjp_zhangwu(flname,money,zhangHu,createtime,description) VALUES (?,?,?,?,?);";
            Object[] params = {zw.getFlname(), zw.getMoney(), zw.getZhangHu(), zw.getCreatetime(), zw.getDescription()};
            qr.update(sql, params);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("账务添加失败");
        }

    }
    public List<ZhangWu> selectAll(){
        try {
            String sql = "SELECT * FROM gjp_zhangwu";
            List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
            return list;
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("账务查询失败");
        }
    }
    public List<ZhangWu> select(String startDate, String endDate){
        try {
            String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
            Object[] params = {startDate, endDate};
            List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class), params);
            return list;
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("账务查询失败");
        }
    }
    public void editZhangWu(ZhangWu zw){
        try {
            String sql = "UPDATE gjp_zhangwu SET flname=?,money=?,zhanghu=?,createtime=?,description=? WHERE zwid=?";
            Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhangHu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
            qr.update(sql, params);
        }catch (SQLException ex){
            System.out.println(ex);
            System.out.println("编辑账务失败");
        }
    }
    public void deleteZhangWu(int ziwd){
        try {
            String sql = "DELETE FROM gjp_zhangwu WHERE zwid=?";
            qr.update(sql, ziwd);
        }catch (SQLException ex){
            System.out.println(ex);
            System.out.println("删除账务失败");
        }

    }
}
