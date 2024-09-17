// GFG
// https://www.geeksforgeeks.org/problems/minimize-the-heights3351/1


class Solution {
    int getMinDiff(int[] arr, int k) {
        int n=arr.length;
        Arrays.sort(arr);
        int min_elem, max_elem;
        int ans = arr[n-1] - arr[0];
        for (int i=1 ; i<=n-1; i++){
            if (arr[i] >= k){
                max_elem = Math.max(arr[i-1] + k, arr[n-1] - k );
                min_elem = Math.min(arr[0] + k, arr[i] - k );
                ans = Math.min(ans, max_elem - min_elem);
            }
            else
                continue;
        }
        return ans;
    }
}
