class Solution {
    public String simplifyPath(String path) {
        String[] arr =path.split("/");
        Deque <String> st = new ArrayDeque<>();

        for(int i=0;i<arr.length;i++){
            String s = arr[i];
            if(s.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else if(s.equals(".") || s.equals("")){
                continue;
            }
            else{
                st.push(s);
            }
        } 

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.insert(0,"/"+st.pop());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}