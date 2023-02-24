package com.spangles.orgtransportmanagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PalindromeTest {
    public static void main(String []args){

        String name = "malayalaM";
        String reverseLetter = "";

        for (int i=0;i<name.length();i++){
            reverseLetter = name.charAt(i) + reverseLetter;
        }
        System.out.println(reverseLetter);
        if(name.equalsIgnoreCase(reverseLetter)){
            System.out.println("Ths is Palindrome");
        }else {
            System.out.println("This is not Palindrome");
        }
        Map<String, Integer> characterCount = new HashMap<>();
        characterCount.put("A", 20);
        characterCount.put("2", 20);
        characterCount.put("f", 20);
        characterCount.put("g", 20);
        characterCount.put("d", 20);


        Set<String> keySet = characterCount.keySet();
        keySet.forEach(System.out::println);
        keySet.forEach(e->System.out.print(e));
        keySet.forEach(e-> {
            System.out.print(e);
        });

        keySet.forEach(e-> {
            int count = characterCount.get(e);
            System.out.println("The count for " + e + ": " + count);
        });
    }
}
