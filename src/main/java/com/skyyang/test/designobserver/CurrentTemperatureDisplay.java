package com.skyyang.test.designobserver;

/**
 * @ClassName CurrentTemperature
 * @Description desc
 * @Author tiancheng.yang
 * @Date 2019/11/25 16:50
 * @Version 1.0
 */
public class CurrentTemperatureDisplay implements Observer, Display{

    public CurrentTemperatureDisplay(Subject subject){
        subject.registerObserver(this);
    }

    @Override
    public void display(String temperature, String humidity, String pressure) {
        System.out.println("current temperature is : " + temperature + " degrees celsius.");
    }

    @Override
    public void update(String temperature, String humidity, String pressure) {
        display(temperature, humidity, pressure);
    }
}
