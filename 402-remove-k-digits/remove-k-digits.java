class Solution {
    public String removeKdigits(String num, int k) {

        // increasing monotonic stack
       Deque <Character> st = new ArrayDeque<>();
        for(char ch : num.toCharArray()){

            while(!st.isEmpty() && k>0 && st.peek()> ch){
                st.pop();
                k--;
            }

            st.push(ch);
        }

        while(k>0){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        sb.reverse();

         // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // If all digits are removed
        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();

    }
}