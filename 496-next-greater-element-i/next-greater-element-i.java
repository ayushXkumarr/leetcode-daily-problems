class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] next =new int [nums2.length];

        Deque <Integer> st = new ArrayDeque<>();
        for(int i= nums2.length -1;i>=0;i--){
            while(!st.isEmpty() && nums2[st.peek()] <= nums2[i]){
                st.pop();
            }

            if(st.isEmpty()){
                next[i] = -1;
            }
            else{
                next[i] = nums2[st.peek()];
            }
            st.push(i);

        } 


        HashMap <Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],next[i]);
        }

        for(int i=0;i<nums1.length;i++){
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;
    }
}