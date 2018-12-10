package com.leetcode.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Question(id = 1, title = "Two Sum", hint = "each input would have exactly one solution, and you may not use the same element twice")
public class ETwoSum {

    @Best(thought = "hashMap, key = nums[i], value = index", complexity = "O(n)")
    static int[] solution(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }


    @Self(thought = "brute force", complexity = "O(n2)")
    static int[] solution2(int[] nums, int target) {
        int left = 0, right = 0;
        int sum = 0;
        int len = nums.length;
        for (; left < len; left++) {
            for (right = left + 1; right < len; right++) {
                sum = nums[left] + nums[right];
                if (sum == target) {
                    return new int[]{left, right};
                }
            }
        }
        return null;
    }

    @Self(thought = "sort & two point", complexity = "O(nlogn)")
    static int[] solution3(int[] nums, int target) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int[] res = {-1, -1};
        int i = 0, j = copy.length - 1;
        while (i < j) {
            int sum = copy[i] + copy[j];
            if (sum == target) {

                for (int k = 0; k < nums.length; k++) {
                    if (nums[k] == copy[i]) {
                        res[0] = k;
                        break;
                    }
                }

                for (int k = 0; k < nums.length; k++) {
                    if (nums[k] == copy[j] && k != res[0]) {
                        res[1] = k;
                        break;
                    }
                }

                if (res[0] > res[1]) {
                    int tmp = res[1];
                    res[1] = res[0];
                    res[0] = tmp;
                }

                return res;

            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        // System.out.println(Arrays.toString(solution(nums, 9)));
        System.out.println(Arrays.toString(solution3(nums, 6)));
    }
}
