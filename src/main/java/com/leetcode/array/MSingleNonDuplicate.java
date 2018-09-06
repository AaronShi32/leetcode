package com.leetcode.array;

public class MSingleNonDuplicate {

    public static int singleNonDuplicate(int[] nums) {
        if(nums == null || nums.length < 2){
            return nums[0];
        }
        int i = 0, j = nums.length - 1;
        boolean count = false;
        while(i < j){
            if(count){
                if(nums[i] == nums[i - 1]){
                    i++;
                } else {
                    return nums[i];
                }
                if(nums[j] == nums[j + 1]){
                    j--;
                } else {
                    return nums[j];
                }
            }else {
                i++;
                j--;
            }
            count = !count;
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5}));
        String a = "";
        char c = '1';
        String result = a + c;
        System.out.println(result.substring(0, 0) + result.substring(1, result.length()));

    }
}
