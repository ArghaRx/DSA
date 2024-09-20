// https://www.geeksforgeeks.org/problems/facing-the-sun2126/1

class Solution {
    // Returns count buildings that can see sunlight
    public int countBuildings(int[] height) {
        // code here
        int cnt = 1;
        int maxi = height[0];
        for(int i = 1; i < height.length; i++)
        {
            if(height[i] > maxi){
                maxi = height[i];
                cnt++;
            }
        }
        return cnt;
    }
}
