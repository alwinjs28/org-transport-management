package com.ma.orgtransportmanagement.util;

public class Mytest {
    static String myName = "Hello" ;
    public static void main(String[] args) {
        System.out.println("Main Method");
    }
    void display() {
        System.out.println("display Method");
    }
    static {

        System.out.println("Static Method:" + myName);
    }
}
