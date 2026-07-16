class Solution {
    public List<String> commonChars(String[] words) {
        HashMap <Character,Integer> map = new HashMap<>();
        for(char ch:words[0].toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(int i=1;i<words.length;i++){
           HashMap <Character,Integer> curr = new HashMap<>(); 

           for(char ch:words[i].toCharArray()){
            curr.put(ch,curr.getOrDefault(ch,0)+1);
            }

            for(char ch:map.keySet()){
                int past = map.get(ch);
                int New= curr.getOrDefault(ch,0);

                if(past > New){
                    map.put(ch,New);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(Map.Entry<Character,Integer> e:map.entrySet()){
            int val = e.getValue();
            while (val > 0) {
                ans.add(String.valueOf(e.getKey()));
                val--;
            }
        }

        return ans;
    }
}