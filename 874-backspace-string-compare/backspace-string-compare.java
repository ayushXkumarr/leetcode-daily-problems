class Solution {

    private String build(Deque<Character> st) {
    StringBuilder sb = new StringBuilder();

    while (!st.isEmpty()) {
        sb.append(st.pop());
    }

    return sb.reverse().toString();
    }
    public boolean backspaceCompare(String s, String t) {
        Deque <Character> st = new ArrayDeque<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '#'){
                if(!st.isEmpty()){
                    st.pop();
                }
                
            }
            else{
                st.push(ch);
            }
        }


        Deque <Character> tt = new ArrayDeque<>();

        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(ch == '#'){
                if(!tt.isEmpty()){
                    tt.pop();
                }
                
            }
            else{
                tt.push(ch);
            }
        }


        return build(st).equals(build(tt));
    }
}