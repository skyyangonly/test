package com.skyyang.test.designobserver.jdkobserver;


import java.util.Observable;

/**
 * @ClassName WeatherData
 * @Description desc
 * @Author tiancheng.yang
 * @Date 2019/11/25 18:51
 * @Version 1.0
 */
public class WeatherData extends Observable {

    void notifyObservers(String temperature, String humidity, String pressure){
        setChanged();
        notifyObservers(temperature);
    }
    void setMeasurement(String temperature, String humidity, String pressure){
        notifyObservers(temperature, humidity, pressure);
    }
}
