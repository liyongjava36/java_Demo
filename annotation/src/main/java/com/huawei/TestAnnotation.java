package com.huawei;

import com.huawei.anno.Check;
import com.huawei.cal.Calculation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Method;

public class TestAnnotation {
    public static void main(String[] args) throws Exception {
        // 获取类加载器
        ClassLoader classLoader = TestAnnotation.class.getClassLoader();
        // 加载要执行的类的字节码文件
        Class<?> calClass = classLoader.loadClass("com.huawei.cal.Calculation");
        // 创建对象
        Calculation cal = (Calculation) calClass.newInstance();
        // 获取要加载类的方法
        Method[] methods = calClass.getMethods();

        // 定义异常的次数
        int num = 0;
        // 创建字符缓冲流写入日志
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        // 遍历方法是否包含@Check注解
        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)){
                // 有，执行方法
                try {
                    method.invoke(cal);
                } catch (Exception e) {
                    // catch 异常 写入到日志文件
                    bw.write(method.getName() + " ： 方法出现异常了");
                    bw.newLine();
                    bw.write("异常名称 ：" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("------------------------------------------");
                    bw.newLine();
                    num++;
                }
            }
        }

        bw.write("本次测试一共出现 " + num + " 次异常");
        bw.close();
    }
}
