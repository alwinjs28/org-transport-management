package com.spangles.orgtransportmanagement;

public class TestExample {
    public static void main(String []args){
       String name = "anish,arun,abish";
       String value  = "arun";
       String splitName[] = name.split(",");
       String correctName = null;
        for (int i=0;i<splitName.length;i++) {
            String names = splitName[i];
            if (names.equals(value)) {
                correctName = value;
            }
        }
        if (correctName == null){
            System.out.println("The Input Is Not Found : "+value);
        }else{
            System.out.println("The Input Is Found : "+correctName);
        }
        boolean matched = false;
        for (int i=0;i<splitName.length;i++) {
            String names = splitName[i];
            if (names.equals(value)) {
                matched = true;
            }
        }
        if (matched){
            System.out.println("The Input Is Not Found : "+value);
        }else{
            System.out.println("The Input Is Found : "+correctName);
        }

    }
}
