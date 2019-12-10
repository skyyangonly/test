package com.skyyang.test.designobserver;

/**
 * @ClassName Subject
 * @Description desc
 * @Author tiancheng.yang
 * @Date 2019/11/25 16:22
 * @Version 1.0
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String temperature, String humidity, String pressure);

}
