class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length()) {
            return ans;
        }

        int[] freq = new int[26];

        // Add pattern
        for (int i = 0; i < p.length(); i++) {
            freq[p.charAt(i) - 'a']++;
        }

        // Remove first window
        for (int i = 0; i < p.length(); i++) {
            freq[s.charAt(i) - 'a']--;
        }

        if (allZero(freq)) {
            ans.add(0);
        }

        // Slide
        for (int right = p.length(); right < s.length(); right++) {

            int left = right - p.length();

            // Leaving character
            freq[s.charAt(left) - 'a']++;

            // Entering character
            freq[s.charAt(right) - 'a']--;

            if (allZero(freq)) {
                ans.add(left + 1);
            }
        }

        return ans;
    }

    private boolean allZero(int[] freq) {

        for (int x : freq) {
            if (x != 0)
                return false;
        }

        return true;
    }
}