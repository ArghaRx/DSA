// https://leetcode.com/problems/count-common-words-with-one-occurrence/description/

//       APPROACH 1
class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        // Fill the first map
        for (String s : words1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }

        // Fill the second map
        for (String s : words2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        int cnt = 0;
        // Loop through the entries of map1 and check the conditions
        for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
            String key = entry1.getKey();
            if (entry1.getValue() == 1 && map2.containsKey(key) && map2.get(key) == 1) {
                cnt++;
            }
        }
        return cnt;
    }
}




//          APPROACH 2

class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(String word : words1)
        map1.put(word, map1.getOrDefault(word, 0) + 1);
        
        for(String word : words2)
        map2.put(word, map2.getOrDefault(word, 0) + 1);

        int cnt = 0;
        for(String word : words2)
        if(map1.containsKey(word) && map2.containsKey(word) && map1.get(word) == 1 && map2.get(word) == 1) cnt++;
        
        return cnt;
    }
}
