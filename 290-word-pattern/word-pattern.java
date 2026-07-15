class Solution {
    public boolean wordPattern(String pattern, String s) {
        String [] word = s.split(" ");
        if(pattern.length() != word.length){
            return false;
        }
        HashMap<Character, String> mapP = new HashMap<>();
        HashMap<String, Character> mapS = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char c1 = pattern.charAt(i);
            String c2 = word[i];

            if (mapP.containsKey(c1)) {

                if (!mapP.get(c1).equals(c2))
                    return false;

            } else {

                mapP.put(c1, c2);

            }

            if (mapS.containsKey(c2)) {

                if (mapS.get(c2) != c1)
                    return false;

            } else {

                mapS.put(c2, c1);

            }

        }

        return true;
    }
}