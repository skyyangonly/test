package com.skyyang.test.designobserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName WeatherData
 * @Description desc
 * @Author tiancheng.yang
 * @Date 2019/11/25 16:30
 * @Version 1.0
 */
public class WeatherData implements Subject{
    static List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers(String temperature, String humidity, String pressure) {
        for(Observer ob : observers){
            ob.update(temperature, humidity, pressure);
        }
    }

    void setMeasurement(String temperature, String humidity, String pressure){
        notifyObservers(temperature, humidity, pressure);
    }

}
