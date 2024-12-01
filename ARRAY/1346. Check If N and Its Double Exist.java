 import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(2 * i) || (i % 2 == 0 && map.containsKey(i / 2))) {
                return true;
            }
            map.put(i, 1);
        }
        return false;
    }
}
