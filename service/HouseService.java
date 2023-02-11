package com.hspedu.houserent.service;

import com.hspedu.houserent.domain.House;

/**
 * 1. 定义House[]，保存House对象
 * 2. 响应HouseView的调用
 * 3. 完成对房屋信息的crud
 *    (1) list()方法 返回houses数组
 *    (2) add(House newHouse)方法 把新的House对象加入到houses数组，返回boolean值
 *    (3)
 */

public class HouseService {

    private House[] houses;//保存House对象
    private int houseNum = 0;//记录当前有多少个房屋信息
    private int idCounter = 0;//记录当前的id增长到哪个值了

    //构造器
    public HouseService(int size) {
        //new houses
        houses = new House[size];//当创建HouseService对象时，指定数组大小
    }
    //list()方法，返回houses数组
    public House[] list() {
        return houses;
    }
    //add(House newHouse)方法 把新的House对象加入到houses数组，返回boolean值
    public boolean add(House newHouse) {
        //判断是否还可以继续添加（暂时不考虑数组扩容的问题）
        if(houseNum == houses.length) {//数组已满
            System.out.println("数组已满，不能再添加了...");
            return false;
        }
        //把新的房屋信息加入houses数组
        houses[houseNum++] = newHouse;
        //设计一个id自增长的机，更新newHouse的id
        newHouse.setId(++idCounter);
        return true;
    }
}
