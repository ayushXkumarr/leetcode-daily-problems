class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap <String,Integer> map = new HashMap<>();
        String [] arr = s1.split(" ");
        String [] arr2 = s2.split(" ");

        for(String s:arr){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for(String s:arr2){
            map.put(s,map.getOrDefault(s,0)+1);
        }

        ArrayList <String> ans = new ArrayList<>();
        for(Map.Entry<String,Integer> e:map.entrySet()){
            if(e.getValue()== 1){
                ans.add(e.getKey());
            }
        }
        String [] ans2 = new String[ans.size()];
        ans.toArray(ans2);
        return ans2;
    }
}