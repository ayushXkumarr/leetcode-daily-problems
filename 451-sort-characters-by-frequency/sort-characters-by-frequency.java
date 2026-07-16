class Solution {
    public String frequencySort(String s) {

        int[] freq = new int[128];

        // Count frequency
        for(char ch : s.toCharArray()){
            freq[ch]++;
        }

        // Store unique characters
        List<Character> list = new ArrayList<>();

        for(int i = 0; i < 128; i++){
            if(freq[i] > 0){
                list.add((char)i);
            }
        }

        // Sort by frequency
        list.sort((a,b) -> freq[b] - freq[a]);

        StringBuilder ans = new StringBuilder();

        // Build answer
        for(char ch : list){
            for(int i = 0; i < freq[ch]; i++){
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}