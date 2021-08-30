public static long mod_exp(long num, long exp, long mod) {
    long res = 1;
    while (exp > 0) {
        if ((exp & 1) == 1) res = (res * num) % mod;
        num = (num * num) % mod;
        exp >>= 1;
    }
    return res % mod;
}