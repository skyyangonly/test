package com.skyyang.test;

import com.skyyang.test.functioninterface.Main;

import javax.swing.*;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class Test
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        int a = 125/100 * 100;
//        System.out.println(a);
//        a = a >>> 1;

//        Date d = new Date(1480166465631L);
//        System.out.println(d);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            Date d2 = sdf.parse("2019-09-01 00:00:00");
//            System.out.println(d2.getTime());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


//        String nameA = "testVariableName";
//        System.out.println("试验能否输出变量名");
//        testName();

//        String s = "指定编码和不指定编码的区别";
//        byte[] local = s.getBytes();
//        byte[] utf8 = s.getBytes("utf-8");

//        new ReflectGetCallerTest().call();

        System.out.println(InterfaceTest.name);
    }

    public static void testName() throws Exception{
        Class cls = Main.class;

        Method method = cls.getDeclaredMethod("method1", String.class, String.class);

        Parameter[] parameters = method.getParameters();
        Arrays.stream(parameters).forEach((p)->{
            System.out.println(p.getName() + ": " + p.getType());
        });
    }
}
