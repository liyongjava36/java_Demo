package com.huawei.test;

public class Example {
    protected String str = new String("good");
    char[] ch = {'a', 'b', 'c'};

    public static void main(String[] args) {
        Example example = new Example();
        System.out.println(example.str + "and");
        System.out.println(example.ch);
    }

    public void change(String strs, char[] a){
        strs = "test ok";
        ch[0] = 'g';
    }
}
