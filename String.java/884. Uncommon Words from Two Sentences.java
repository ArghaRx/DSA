// https://leetcode.com/problems/uncommon-words-from-two-sentences/description/



class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String arr1[] = s1.split(" ");
        String arr2[] = s2.split(" ");
        Map<String , Integer> map = new HashMap<>();
        for(int i = 0; i < arr1.length; i++)
        {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        for(int i = 0; i < arr2.length; i++)
        {
            map.put(arr2[i], map.getOrDefault(arr2[i], 0) + 1);
        }

        ArrayList<String> ans = new ArrayList<>();
        for(Map.Entry<String, Integer> m : map.entrySet())
        {
            if(m.getValue() == 1) ans.add(m.getKey());
        }

        String a[] = new String[ans.size()];
        int ind = 0;
        for(String s : ans)
        a[ind++] = s;

        return a;
    }
}
