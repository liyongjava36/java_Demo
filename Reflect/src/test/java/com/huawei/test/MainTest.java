package com.huawei.test;

public class MainTest {
    public static void main(String[] args) {
        int a = 10,b = 4,c = 20, d = 6;
        a = a++ * b + c * --d;
        System.out.println(a % 2 == 1 ?(a + 1) / 2 : a / 2);
        System.out.println(a);
    }
}
