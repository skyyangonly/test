package com.skyyang.test;

/**
 * @ClassName TestFinalize
 * @Description desc
 * @Author tiancheng.yang
 * @Date 2019/11/26 16:29
 * @Version 1.0
 */
public class FinalizeTest {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize() ...");
        super.finalize();
    }
    public static void main(String[] args){
        FinalizeTest ft = new FinalizeTest();


        ft = null;
        System.gc();
        System.out.println("while ...");
        while(true) { }
    }
}
