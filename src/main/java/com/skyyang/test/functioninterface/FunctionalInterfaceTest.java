package com.skyyang.test.functioninterface;

@FunctionalInterface
public interface FunctionalInterfaceTest {

    String parseName(String name) ;

    default String see(){
        return "you're beautiful ";
    }

    String toString();

}
