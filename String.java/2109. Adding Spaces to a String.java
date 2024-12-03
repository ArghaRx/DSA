class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder ans = new StringBuilder(); // Use StringBuilder for efficient string manipulation
        int ind = 0; // Track the current index in the spaces array
        int n = s.length();
      
        for (int i = 0; i < s.length(); i++)
        {
            if(ind < spaces.length && i == spaces[ind])
            {
                ans.append(' ');
                ind++;  
            }
            ans.append(s.charAt(i));
        }

        return ans.toString();
    }
}
