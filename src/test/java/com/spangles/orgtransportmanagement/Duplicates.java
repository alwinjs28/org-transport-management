package com.spangles.orgtransportmanagement;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Duplicates {
    public static void main(String [] args){

        int a[] = {1,8,2,6,3,4,3,5,5};

        List<Integer> withOutDuplicates = Arrays.stream(a).boxed().distinct().collect(Collectors.toList());
        withOutDuplicates.forEach(System.out::println);
        System.out.println(withOutDuplicates);

        List<Integer> removedDuplicates = new ArrayList<>();
//        int withoutDuplicates [] = new int[removedDuplicates.size()];
        int temp;
        for (int i=0;i< a.length;i++){
            for (int j=i;j<a.length;j++){
                if (a[i] > a[j]){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp ;

                }

            }
        }
        for (int i=0;i<a.length;i++){
            System.out.println("The Sorted Number is : "+a[i]);
        }
        for (int i=0;i<a.length-1;i++) {
            if (a[i] != a[i+1] ) {
                removedDuplicates.add(a[i]);
                if (i == a.length-2){
                    removedDuplicates.add(a[i+1]);
                }
            }
        }
        for (Integer removedDuplicate : removedDuplicates){
            System.out.println(removedDuplicate);
        }
        int[] removedDuplicatesArr = new int[removedDuplicates.size()];
        for (int i=0;i<removedDuplicates.size();i++){
            removedDuplicatesArr[i] = removedDuplicates.get(i);
        }
        for (int i=0;i<removedDuplicatesArr.length;i++){
            System.out.println("The duplicate removed Number is : "+removedDuplicatesArr[i]);
        }
    }
}
