package com.contest;

import com.util.Contest;

import java.util.Arrays;

@Contest(id = 65)
public class MBoatstoSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int min = 0;
        while(i <= j){
            if(people[j] >= limit){
                j--;
                min++;
            }else{
                int weight = people[i] + people[j];
                if(weight <= limit){
                    i++;
                    j--;
                }else{
                    j--;
                }
                min++;
            }
        }
        return min;
    }

    public static void main(String[] args){
        int[] people = {1,2};
        MBoatstoSavePeople c = new MBoatstoSavePeople();
        System.out.println(c.numRescueBoats(people, 3));
        StringBuilder sb = new StringBuilder("");
    }

}
