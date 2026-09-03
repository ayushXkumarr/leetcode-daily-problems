class Solution {
    public int kthGrammar(int n, int k) {
        if(n==1){
            return 0;
        }

        int half = (int) Math.pow(2,(n-2));
        // int half= length/2;

        if(k<=half){
            return kthGrammar(n-1,k);
        }else{
            return flip(kthGrammar(n-1,k-half));
        }

    }

    static int flip(int val){
        if(val ==0){
            return 1;
        }
        else{
            return 0;
        }
    }
}