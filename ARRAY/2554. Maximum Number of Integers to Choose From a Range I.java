import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int num : banned) {
            set.add(num); // Add all banned numbers to the set
        }

        int sum = 0;
        int count = 0; // Track the number of integers selected

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i) && sum + i <= maxSum) {
                sum += i;  // Add the number to the sum
                count++;   // Increment the count
            }
            if (sum + i > maxSum) break; // Stop if adding the next number exceeds maxSum
        }

        return count; // Return the count of numbers selected
    }
}


