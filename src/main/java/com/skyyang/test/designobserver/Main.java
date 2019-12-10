package com.skyyang.test.designobserver;

/**
 * @ClassName Main
 * @Description desc
 * @Author tiancheng.yang
 * @Date 2019/11/25 16:54
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args){

        WeatherData weatherData = new WeatherData();
        CurrentTemperatureDisplay observer = new CurrentTemperatureDisplay(weatherData);

        weatherData.setMeasurement("30", "28" , "99");


    }
}
