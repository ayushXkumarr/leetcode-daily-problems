class Solution {
    public boolean checkInclusion(String s1, String s2) {
        

        int [] target = new int [26];
        int [] window = new int [26];

        if (s1.length() > s2.length()) {
            return false;
        }

        for(int i=0;i<s1.length();i++){
            target[s1.charAt(i) - 'a']++;
        }

        for(int i=0;i<s1.length();i++){
            window[s2.charAt(i) - 'a']++;
        }

        if(isequal(target ,window)){
            return true;
        }

        for(int i=s1.length();i<s2.length();i++){
            int left = i - s1.length();
            window[s2.charAt(left) - 'a']--;
            window[s2.charAt(i) - 'a'] ++;

            if(isequal(target ,window)){
                return true;
            }
        }

        return false;
    }


    private boolean isequal(int[] target, int[] window) {

        for (int i = 0; i < 26; i++) {
            if (target[i] != window[i]) {
                return false;
            }
        }

        return true;
    }
    
}