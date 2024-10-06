//https://www.youtube.com/watch?v=J9KwcuukMZE

//T.C : O(m+n)
//S.C : O(m+n)

class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.length() < sentence2.length())
        {
            String temp = sentence1;
            sentence1 = sentence2;
            sentence2 = temp;
        }

        // Splitting strings by spaces
        String arr1[] = sentence1.split(" ");
        String arr2[] = sentence2.split(" ");

        int i = 0, j = arr1.length - 1; // for array1
        int k = 0, l = arr2.length - 1; // for array2

        // Check for matching prefix
        while(i < arr1.length && k < arr2.length && arr1[i].equals(arr2[k]))
        {
            i++;
            k++;
        }

        // Check for matching suffix
        while(j >= i && l >= k && arr1[j].equals(arr2[l]))
        {
            j--;
            l--;
        }

        return k > l;
    }
}
