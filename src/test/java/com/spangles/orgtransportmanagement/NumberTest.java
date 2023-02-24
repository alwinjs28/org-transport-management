package com.spangles.orgtransportmanagement;

public class NumberTest {
    public static void main(String [] args){
        int number=100;

        for (int i=1; i<=number-1; i++){

            if (i%2 == 0 || i%3 == 0 || i%5 == 0){
                System.out.print(" "+i);
            }
        }
    }
}
