package com.spangles.orgtransportmanagement;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NameTest{
    public static void main(String[] args){
        String name1 = "name=\"Alwin\"       \\\\\"I printed backslash";
        System.out.println(name1);
        String name = "Naman".toLowerCase();
        int count = name.length();
        Map<Character, Integer> mapCharacter = new HashMap<>();
        try {

            for (int i = 0; i < count; i++) {
                char a = name.charAt(i);
                if (mapCharacter.get(a) != null) {
                    int count2 = mapCharacter.get(a);
                    count2++;
                    mapCharacter.put(a, count2);

                } else {
                    mapCharacter.put(a, 1);
                }
            }
            Set<Character> keySet = mapCharacter.keySet();
            for (Character s : keySet) {
                System.out.println(" " + s + " " + mapCharacter.get(s));
            }
        }catch (Exception e){
            System.out.println("Problem Is Here");
        }
    }
}
