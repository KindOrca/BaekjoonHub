class Solution {
    static final int MOD = 10007;

    public int solution(int n, int[] tops) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = tops[0] == 1 ? 4 : 3;
        for (int i = 2; i <= n; i++) {
            long a = (tops[i - 1] == 1 ? 3L * dp[i - 1] : 2L * dp[i - 1]) % MOD;
            long b = ((dp[i - 1] - dp[i - 2]) % MOD + MOD) % MOD;
            dp[i] = (int) ((a + b) % MOD);
        }
        return dp[n];
    }
}