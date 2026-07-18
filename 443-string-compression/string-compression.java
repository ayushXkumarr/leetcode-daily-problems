class Solution {
    public int compress(char[] chars) {
        int write =0;
        for(int read=0;read<chars.length;){
            char ch = chars[read];
            int count =0;

            while (read<chars.length && chars[read] == ch){
                count++;
                read++;
            }

            chars[write++] = ch;
            if(count>1){
                for(char cha : String.valueOf(count).toCharArray()){
                    chars[write++] = cha;
                }
            }

        }

        return write;
    }
}