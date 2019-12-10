package com.skyyang.test.designobserver.jdkobserver;

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName CurrentTemperatureDisplay
 * @Description desc
 * @Author tiancheng.yang
 * @Date 2019/11/25 18:54
 * @Version 1.0
 */
public class CurrentTemperatureDisplay implements Observer, Display {


    public CurrentTemperatureDisplay(Observable observable){
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        String temperature = arg==null?"":arg.toString();
        display(temperature, null, null);
    }

    @Override
    public void display(String temperature, String humidity, String pressure) {
        System.out.println("current temperature is : " + temperature );
    }
}
