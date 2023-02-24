package com.spangles.orgtransportmanagement;

import java.sql.SQLException;

public class ExceptionHandling {
    public static void main(String[] args){

        String s = "5656.7";
        try {
            Integer.parseInt(s);
            System.out.println("The given number is Integer");
        }catch (NumberFormatException e){
            System.out.println("There is a problem to converting string to integer.. So trying to convert to double");
            try {
                Double.parseDouble(s);
                System.out.println("This is Double");
            }catch (Exception e1) {
                System.out.println("There is a problem to converting string to double.. So trying to convert to Boolean");

                boolean value = s.equalsIgnoreCase("true") || s.equalsIgnoreCase("false");
                if (value){
                    System.out.println("The given value is Boolean");
                }else {
                    System.out.println("The given value is string");
                }
            }
        }

    }
}
