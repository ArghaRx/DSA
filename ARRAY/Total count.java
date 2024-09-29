// https://www.geeksforgeeks.org/problems/total-count2415/1



class Solution {
    int totalCount(int k, int[] arr) {
        // code here
        int cnt = 0;
        for(int i : arr)
        {
            if(i % k == 0) cnt += i / k;
            else cnt += (i / k) + 1;
        }
        return cnt;
    }
}
