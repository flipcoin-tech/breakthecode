/*
 * Problem: https://leetcode.com/problems/two-sum/
 */

package leetcode;

import java.util.*;

public class TwoSum {
 
  // Approach1: Brute Force -> O(n2)
  public static int[] twoSum1(int[] nums, int target) {
    for (int i=0; i<nums.length; i++) {
      for (int j=i+1; j<nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }
    return new int[] {};
  }

  // Approach2: HashMap -> O(n)
  public static int[] twoSum2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i=0; i<nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
      } else {
        map.put(nums[i], i);
      }
    }
    return new int[] {};
  }


}