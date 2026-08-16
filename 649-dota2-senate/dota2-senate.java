class Solution {
    public String predictPartyVictory(String senate) {

        char[] arr = senate.toCharArray();

        Queue<Character> r = new ArrayDeque<>();
        Queue<Character> d = new ArrayDeque<>();

        // Count alive senators
        for (char ch : arr) {
            if (ch == 'R') {
                r.offer('R');
            } else {
                d.offer('D');
            }
        }

        int i = 0;

        while (!r.isEmpty() && !d.isEmpty()) {

            // Current senator is already banned
            if (arr[i] == 'X') {
                i = (i + 1) % arr.length;
                continue;
            }

            // R's turn
            if (arr[i] == 'R') {

                // R bans one D
                d.poll();

                // Find next alive D and mark it banned
                int j = (i + 1) % arr.length;

                while (arr[j] != 'D') {
                    j = (j + 1) % arr.length;
                }

                arr[j] = 'X';

            } 
            // D's turn
            else {

                // D bans one R
                r.poll();

                // Find next alive R and mark it banned
                int j = (i + 1) % arr.length;

                while (arr[j] != 'R') {
                    j = (j + 1) % arr.length;
                }

                arr[j] = 'X';
            }

            // Move to next position
            i = (i + 1) % arr.length;
        }

        return r.isEmpty() ? "Dire" : "Radiant";
    }
}