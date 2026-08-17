class Solution {
    public int sumSubarrayMins(int[] arr) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] prev = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                prev[i] = -1;
            } else {
                prev[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        int[] next = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                next[i] = arr.length;
            } else {
                next[i] = st.peek();
            }

            st.push(i);
        }

        long contri = 0;
        long MOD = 1000000007;

        for (int i = 0; i < arr.length; i++) {

            long left = i - prev[i];
            long right = next[i] - i;

            contri = (contri + (long) arr[i] * left * right) % MOD;
        }

        return (int) contri;

    }
}