// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/description/


class Solution {
    public char findKthBit(int n, int k) {
        String s = "0";
        n -= 1;
        while (n != 0) {
            StringBuilder sb = new StringBuilder(s);
            sb = invert(sb.reverse());
            s = s + "1" + sb;
            n--;
        }
        return s.charAt(k - 1);
    }

    public StringBuilder invert(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                sb.setCharAt(i, '0');
            } else {
                sb.setCharAt(i, '1');
            }
        }
        return sb;
    }
}
