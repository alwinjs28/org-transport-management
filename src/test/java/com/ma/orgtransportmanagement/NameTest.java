package com.ma.orgtransportmanagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NameTest{
    public static void main(String[] args){
        String name = "Naman".toLowerCase();
        int count = name.length();
        Map<Character, Integer> mapCharacter = new HashMap();
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
    }
}
