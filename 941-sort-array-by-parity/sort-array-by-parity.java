class Solution {
    public int[] sortArrayByParity(int[] arr) {
        int i =0;
        int n = arr.length - 1;
        
        while(i<n){
            if(arr[i] %2 ==0){
                i++;
            }else{
                int temp = arr[i];
                arr[i]=arr[n];
                arr[n]=temp;
                
                
                n--;
            }
        }


        return arr;
    }
}