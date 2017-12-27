package com.topic.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Question(id = 18, title = "4Sum", hint = "" +
        "1. elements a, b, c, and d in S such that a + b + c + d = target" +
        "2. not contain duplicate quadruplets")
public class M4Sum {

    @Best
    @Self(thought = "sort + binary + dimensionality reduction", complexity = "O(n3)")
    static List<List<Integer>> solution(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int k = 0; k + 3 < len; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int three = target - nums[k];
            for (int t = k + 1; t + 2 < len; t++) {
                if (t > k + 1 && nums[t] == nums[t - 1]) {
                    continue;
                }
                int two = three - nums[t];
                int i = t + 1;
                int j = len - 1;
                while (i < j) {
                    int group = nums[i] + nums[j];
                    if (group == two) {
                        ret.add(Arrays.asList(nums[k], nums[i], nums[j], nums[t]));
                        i++;
                        j--;
                        while (i < j && nums[i] == nums[i - 1]) i++;  // skip same result
                        while (i < j && nums[j] == nums[j + 1]) j--;  // skip same result
                    } else if (group > two) {
                        j--;
                    } else {
                        i++;
                    }
                }
            }

        }

        return ret;
    }


    public static void main(String[] args) {
        int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
        System.out.println(solution(nums, -9));
    }
}
