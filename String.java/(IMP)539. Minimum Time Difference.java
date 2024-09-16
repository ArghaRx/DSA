// https://leetcode.com/problems/minimum-time-difference/description/

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int arr[] = new int[timePoints.size()];
        int ind = 0;
        for(String str : timePoints)
        {
            String s[] = str.split(":");
            int hour = Integer.parseInt(s[0]);
            int minute = Integer.parseInt(s[1]);
            arr[ind++] = (hour * 60) + minute;
        }

        Arrays.sort(arr);
        int val = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++)
        {
            val = Math.min(val, arr[i + 1] - arr[i]);
        }
        // Handle the wrap-around case (comparing the first and last time point)
        int wrapAroundDiff = 1440 + arr[0] - arr[arr.length - 1] ;
        val = Math.min(val, wrapAroundDiff);

        return val;
    }
}
