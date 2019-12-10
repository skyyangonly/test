package com.skyyang.test;

import sun.reflect.Reflection;

/**
 * @ClassName ReflectGetCallerTest
 * @Description desc
 * @Author tiancheng.yang
 * @Date 2019/12/9 14:44
 * @Version 1.0
 */
public class ReflectGetCallerTest {

    public void call(){
        Class cls = Reflection.getCallerClass();
        System.out.println("caller is " + cls.getName());
    }
}
