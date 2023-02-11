package com.hspedu.houserent.view;

import com.hspedu.houserent.domain.House;
import com.hspedu.houserent.service.HouseService;
import com.hspedu.houserent.utils.Utility;

/**
 * 1. 显示界面
 * 2. 接受用户输入
 * 3. 调用HouseService完成对房屋信息的各种操作
 *    (1) listHouses方法 显示房屋列表
 *    (2) addHouse方法 添加房屋信息
 */
public class HouseView {

    private boolean loop = true;//控制显示菜单
    private char key = ' ';//接受用户输入
    private HouseService houseService = new HouseService(10);

    //显示主菜单
    public void mainMenu() {

        do {
            System.out.println("\n=========房屋出租系统菜单=========");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 源");
            System.out.println("\t\t\t3 删除房屋信息");
            System.out.println("\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t5 显示房屋信息");
            System.out.println("\t\t\t6 退      出");
            System.out.print("请输入你的选择（1～6）：");
            key = Utility.readChar();
            switch (key) {
                case '1' :
                    addHouse();
                    break;
                case '2' :
                    System.out.println("查找");
                    break;
                case '3' :
                    System.out.println("删除");
                    break;
                case '4' :
                    System.out.println("修改");
                    break;
                case '5' :
                    listHouses();
                    break;
                case '6' :
                    System.out.println("退出");
                    loop = false;
                    break;
            }

        }while(loop);
    }
    //编写listHouses() 显示房屋列表，调用list()方法
    public void listHouses() {
        System.out.println("---------房屋列表---------");
        System.out.println("编号\t房主\t电话\t地址\t月租\t状态（已出租/未出租）");
        House[] houses = houseService.list();
        //遍历输出
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null){//如果为null，就不用再显示了
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("---------完   毕---------");
    }
    //编写addHouse() 添加房屋信，调用add(House newHouse)方法
    public void addHouse() {
        System.out.println("---------添加房屋---------");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(3);
        //创建一个新的House对象，注意id时系统分配的，用户不能输入
        House house = new House(100, name, phone, address, rent, state);
        if(houseService.add(house)) {
            System.out.println("---------添加房屋成功---------");
        } else {
            System.out.println("---------添加房屋失败---------");
        }
    }
}
