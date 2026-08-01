class StockSpanner {
    class pair{
        int value;
        int span;
        pair(int value,int span){
            this.span=span;
            this.value=value;
        }

        
    }
    Deque <pair> st ;
    public StockSpanner() {
        st = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span = 1;

        while (!st.isEmpty() && st.peek().value <= price) {
            span += st.peek().span;
            st.pop();
        }

        st.push(new pair(price, span));

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */