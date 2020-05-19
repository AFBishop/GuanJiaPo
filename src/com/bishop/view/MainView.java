package com.bishop.view;

import com.bishop.controller.ZhangWuController;
import com.bishop.domain.ZhangWu;
import com.bishop.service.ZhangWuService;

import java.util.List;
import java.util.Scanner;

public class MainView {
    private ZhangWuController controller = new ZhangWuController();
    public void run(){
        boolean flag = true;
        Scanner in = new Scanner(System.in);
        while (flag){
            System.out.println("---------------管家婆家庭记账软件---------------");
            System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
            System.out.println("请输入要操作的功能序号[1-5]:");

            int option = in.nextInt();
            switch (option){
                case 1:
                    addZhangWu();
                    // 添加账务
                    break;
                case 2:
                    editZhangWu();
                    // 编辑账务
                    break;
                case 3:
                    deleteZhangWu();
                    // 删除账务
                    break;
                case 4:
                    selectZhangWu();
                    // 查询账务
                    break;
                case 5:
                    // 退出系统
                    System.out.println("再见！");
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误！");
            }
        }
    }
    public void addZhangWu(){
        System.out.println("选择的添加账务功能，请输入以下内容");
        Scanner in = new Scanner(System.in);
        System.out.println("输入分类名称");
        String flname = in.next();
        System.out.println("输入账户名称");
        String zhangHu = in.next();
        System.out.println("输入金额");
        double money = in.nextDouble();
        System.out.println("输入时间，格式xxxx-xx-xx");
        String createtime = in.next();
        System.out.println("输入费用说明");
        String description = in.next();

        ZhangWu zw = new ZhangWu(0, flname,money, zhangHu, createtime, description);
        controller.addZhangWu(zw);
        System.out.println("账务添加成功！");
    }
    public void editZhangWu(){
        selectAll();
        System.out.println("选择的是编辑功能，请输入数据");
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入ID");
        int zwid = sc.nextInt();
        System.out.println("输入分类名称");
        String flname = sc.next();
        System.out.println("输入金额");
        double money = sc.nextDouble();
        System.out.println("输入账户");
        String zhangHu = sc.next();
        System.out.println("输入日期：格式XXXX-XX-xx");
        String createtime = sc.next();
        System.out.println("输入具体描述");
        String description = sc.next();
        ZhangWu zw = new ZhangWu(zwid, flname,money, zhangHu, createtime, description);
        controller.editZhangWu(zw);
        System.out.println("编辑账务成功");

    }
    public void deleteZhangWu(){
        selectAll();
        System.out.println("选择的是删除功能，请输入序号即可");
        int zwid = new Scanner(System.in).nextInt();
        //调用控制层方法，传递主键id即可
        controller.deleteZhangWu(zwid);
        System.out.println("删除账务成功");

    }
    public void selectZhangWu(){
        System.out.println("1.查询所有　2.按条件查询");
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        switch (option){
            case 1:
                //查询所有
                selectAll();
                break;
            case 2:
                //按条件查询
                select();
                break;
            default:
                System.out.println("输入错误！");
        }
    }
    public void selectAll(){
        List<ZhangWu> list = controller.selectAll();
        if (list.size() > 0){
            print(list);
        }else {
            System.out.println("没有查到数据");
        }
    }
    public void select(){
        System.out.println("选择条件查询,输入日期格式XXXX-XX-XX");
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入开始日期:");
        String startDate = sc.nextLine();
        System.out.print("请输入结果日期:");
        String endDate = sc.nextLine();
        List<ZhangWu> list = controller.select(startDate, endDate);
        if(list.size()!=0)
            print(list);
        else
            System.out.println("没有查询到数据");
    }
    public void print(List<ZhangWu> list){
        System.out.println("ID\t\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
        for (ZhangWu zw : list){
            System.out.println(zw.getZwid()+"\t\t"+zw.getFlname()+"\t\t"+zw.getZhangHu()+"\t\t"+
                    zw.getMoney()+"\t\t"+zw.getCreatetime()+"\t"+zw.getDescription());
        }
    }


}
