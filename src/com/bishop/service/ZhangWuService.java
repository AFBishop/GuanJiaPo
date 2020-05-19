package com.bishop.service;

import com.bishop.dao.ZhangWuDao;
import com.bishop.domain.ZhangWu;

import java.util.List;

public class ZhangWuService {
    private ZhangWuDao zhangWuDao = new ZhangWuDao();
    public void addZhangWu(ZhangWu zw){
        zhangWuDao.addZhangWu(zw);
    }
    public List<ZhangWu> selectAll(){
         return zhangWuDao.selectAll();
    }
    public List<ZhangWu> select(String startDate, String endDate){
        return zhangWuDao.select(startDate, endDate);
    }
    public void editZhangWu(ZhangWu zw){
        zhangWuDao.editZhangWu(zw);
    }
    public void deleteZhangWu(int zwid){
        zhangWuDao.deleteZhangWu(zwid);
    }
}
