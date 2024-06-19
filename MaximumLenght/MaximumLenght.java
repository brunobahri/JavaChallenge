import java.util.*;

class Solution {
    public int maxLength(List<String> arr) {
        return maxLengthHelper(arr, 0, "");
    }

    private int maxLengthHelper(List<String> arr, int index, String current) {
        if (!isUnique(current)) {
            return 0;
        }
        if (index == arr.size()) {
            return current.length();
        }
        int include = maxLengthHelper(arr, index + 1, current + arr.get(index));
        int exclude = maxLengthHelper(arr, index + 1, current);
        return Math.max(include, exclude);
    }

    private boolean isUnique(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            if (charCount[c - 'a']++ > 0) {
                return false;
            }
        }
        return true;
    }
}
