package com.huawei.cal;

import com.huawei.anno.Check;

public class Calculation {
    @Check
    public void add() {
        System.out.println("1 + 0 = " + (1 + 0));
    }

    @Check
    public void div() {
        System.out.println("1 / 0 =" + (1 / 0));
    }

    @Check
    public void TestString() {
        String str = null;
        boolean equals = str.equals("1");
        System.out.println("执行TestString");
    }
}
