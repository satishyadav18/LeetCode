class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int LIMIT = 2048; // > max possible XOR value (values <= 1500)

        boolean[] present = new boolean[LIMIT];
        for (int x : nums) present[x] = true;

        // collect distinct values
        int d = 0;
        int[] distinct = new int[LIMIT];
        for (int v = 0; v < LIMIT; v++) if (present[v]) distinct[d++] = v;

        // Step 1: pairwise XOR closure
        boolean[] pairXor = new boolean[LIMIT];
        for (int i = 0; i < d; i++) {
            int u = distinct[i];
            for (int j = 0; j < d; j++) {
                pairXor[u ^ distinct[j]] = true;
            }
        }

        // Step 2: combine with a third element
        boolean[] tripleXor = new boolean[LIMIT];
        for (int i = 0; i < d; i++) {
            int u = distinct[i];
            for (int w = 0; w < LIMIT; w++) {
                if (pairXor[w]) tripleXor[u ^ w] = true;
            }
        }

        int ans = 0;
        for (int v = 0; v < LIMIT; v++) if (tripleXor[v]) ans++;
        return ans;
    }
}