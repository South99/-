package com.hspedu.houserent.utils;

public class TestUtility {
    public static void main(String[] args) {

        //这是一个测试类，使用完毕就可以删除了

        //要求输入一个字符串，长度最大为3
        String s = Utility.readString(3);
        System.out.println("s=" + s);

        //要求输入一个字符串，长度最大为10，如果没有输入用户直接回车，就给一个默认值"hspedu"
        //提示：就把该方法当作一个api使用即可
        System.out.print("请输入字符串：");
        String s2 = Utility.readString(10, "hspedu");
        System.out.println("s2=" + s2);


    }
}
