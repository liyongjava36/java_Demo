package com.huawei.reflect;

import com.huawei.po.Person;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 案例：
 * 	* 需求：写一个"框架"，不能改变该类的任何代码的前提下，可以帮我们创建任意类的对象，并且执行其中任意方法
 * 		* 实现：
 * 			1. 配置文件
 * 			2. 反射
 * 		* 步骤：
 * 			1. 将需要创建的对象的全类名和需要执行的方法定义在配置文件中
 * 			2. 在程序中加载读取配置文件
 * 			3. 使用反射技术来加载类文件进内存
 * 			4. 创建对象
 * 			5. 执行方法
 * @since 1.8
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        // 创建类加载器
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        // 加载配置文件
        InputStream in = classLoader.getResourceAsStream("pro.properties");
        Properties properties = new Properties();
        properties.load(in);
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        // 创建字节码对象
        Class<?> aClass = Class.forName(className);
        // 反射创建对象
        Person person = (Person) aClass.newInstance();
        // 获取方法对象
        Method method = aClass.getMethod(methodName);
        // 执行方法
        method.invoke(person);
    }
}
