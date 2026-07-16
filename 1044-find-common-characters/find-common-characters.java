class Solution {

    public List<String> commonChars(String[] words) {

        List<String> ans = new ArrayList<>();

        // Make a copy because we'll modify the strings
        String[] copy = words.clone();

        for (char ch : copy[0].toCharArray()) {

            boolean foundInAll = true;

            // Check every other word
            for (int i = 1; i < copy.length; i++) {

                int index = copy[i].indexOf(ch);

                if (index == -1) {
                    foundInAll = false;
                    break;
                }

                // Remove only one occurrence
                copy[i] = copy[i].substring(0, index)
                        + copy[i].substring(index + 1);
            }

            if (foundInAll) {
                ans.add(String.valueOf(ch));
            }
        }

        return ans;
    }
}