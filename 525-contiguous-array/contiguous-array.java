import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Store sum 0 at index -1
        map.put(0, -1);

        int count = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            
            // Treat 0 as -1 and 1 as +1
            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }

            // If same count appears, subarray has equal 0s and 1s
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                // Store first occurrence of count
                map.put(count, i);
            }
        }

        return maxLen;
    }
}