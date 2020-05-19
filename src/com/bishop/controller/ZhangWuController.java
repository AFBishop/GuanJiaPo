package com.bishop.controller;

import com.bishop.domain.ZhangWu;
import com.bishop.service.ZhangWuService;

import java.util.List;

public class ZhangWuController {
    private ZhangWuService service =  new ZhangWuService();
    public void addZhangWu(ZhangWu zw){
        service.addZhangWu(zw);
    }
    public List<ZhangWu> select(String startDate, String endDate){
        return service.select(startDate, endDate);

    }
    public List<ZhangWu> selectAll(){
        return service.selectAll();
    }
    public void editZhangWu(ZhangWu zw){
        service.editZhangWu(zw);
    }
    public void deleteZhangWu(int zwid){
        service.deleteZhangWu(zwid);
    }
}
