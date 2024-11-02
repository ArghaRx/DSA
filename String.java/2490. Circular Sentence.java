// https://leetcode.com/problems/circular-sentence/description/


class Solution {
    public boolean isCircularSentence(String sentence) {
        String arr[] = sentence.split(" ");

        String first = arr[0];
        String last = arr[arr.length - 1];

        //The last character of the last word is equal to the first character of the first word.
        if(first.charAt(0) != last.charAt(last.length() - 1)) 
        {
            return false;
        }

        // The last character of a word is equal to the first character of the next word.
        for(int i = 0; i < arr.length - 1; i++)
        {
            if(arr[i].charAt(arr[i].length() - 1) != arr[i + 1].charAt(0)) return false;
        }

        
        return true;
    }
}
