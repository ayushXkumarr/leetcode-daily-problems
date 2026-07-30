class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack();
        int ans = 0;

        for(String op : ops) {
            if (op.equals("+")) {
                int first = st.pop();
                int second = st.peek();
                st.push(first);
                st.push(first + second);
            } else if (op.equals("C")) {
                st.pop();
                
            } else if (op.equals("D")) {
                st.push(2 * st.peek());
            } else {
                st.push(Integer.valueOf(op));
            }
            
        }
         int sum = 0;

        while (!st.isEmpty()) {
            sum += st.pop();
        }

        return sum;
    }
}