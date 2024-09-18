
import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        // Handle the edge case where all numbers are zero
        boolean allZero = true;
        for (int num : nums) {
            if (num != 0) {
                allZero = false;
                break;
            }
        }
        if (allZero) return "0";

        // Define the comparator
        Comparator<Integer> com = new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                String s1 = Integer.toString(i);
                String s2 = Integer.toString(j);
                String order1 = s1 + s2;
                String order2 = s2 + s1;

                /*
Using Integer.valueOf() or Integer.parseInt() for comparing concatenated strings is not appropriate in this context because these methods are designed to convert strings to integer values. They do not handle very large numbers resulting from concatenation of two integers in a way that avoids overflow issues.
                */
                // Compare concatenated strings
             // Compare concatenated strings with if-else
                if (order1.compareTo(order2) > 0) {
                    return -1;  // Order1 should come before Order2
                } else if (order1.compareTo(order2) < 0) {
                    return 1;   // Order2 should come after Order2
                } else {
                    return 0;   // Both are equal
                }
            }
        };

        // Convert the primitive int[] array to an Integer[] array
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        // Sort the array using the custom comparator
        Arrays.sort(arr, com);

        // Build the largest number as a string
        StringBuilder sb = new StringBuilder();
        for (Integer num : arr) {
            sb.append(num);
        }

        return sb.toString();
    }
}
