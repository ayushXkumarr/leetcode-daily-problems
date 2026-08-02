class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        Deque<Integer> st = new ArrayDeque<>();

        // Previous Smaller
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                prevSmaller[i] = -1;
            } else {
                prevSmaller[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // Next Smaller
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nextSmaller[i] = n;
            } else {
                nextSmaller[i] = st.peek();
            }

            st.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int width = nextSmaller[i] - prevSmaller[i] - 1;
            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}