package com.skyyang.test.functioninterface;

/**
 * @ClassName Plate
 * @Description desc
 * @Author tiancheng.yang
 * @Date 2019/11/22 15:50
 * @Version 1.0
 */
public class Plate {


    public Plate(){
        System.out.println("Plate()");
    }

    public Plate(String a){
        System.out.println("Plate(String a) : " + a);
    }

    public String fly(){
        return "I can fly";
    }

    public String boom(){
        return "boom";
    }

    static String fire(String target){
        return "shoot target :" + target;
    }
}
