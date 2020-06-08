package jzl.com.algorithm.week5;

import java.math.BigInteger;
import java.util.Random;

public class RabinKarp {

    private String pat;
    private long patHash;
    private int M;
    private long q;
    private int R = 256;
    private long RM;

    public RabinKarp(String pat) {
        this.pat = pat;
        this.M = pat.length();
        q = longRandomPrime();
        RM = 1;
        for (int i = 1; i <= M - 1; i++) {
            RM = (R * RM) % q;
        }
        patHash = hash(pat, M);
    }

    private long hash(String key, int m) {
        long h = 0;
        for (int j = 0; j < m; j++) {
            h = (R * h + key.charAt(j)) % q;
        }
        return h;
    }

    public boolean check(int i) {
        return true;
    }

    private boolean check(String txt, int i) {
        for (int j = 0; j < M; j++) {
            if (pat.charAt(j) != txt.charAt(i + j)) {
                return false;
            }
        }
        return true;
    }

    public int search(String txt) {
        int n = txt.length();
        if (n < M) {
            return n;
        }
        long txtHash = hash(txt, M);
        if ((patHash == txtHash) && check(txt, 0)) {
            return 0;
        }
        for (int i = M; i < n; i++) {
            txtHash = (txtHash + q - RM * txt.charAt(i - M) % q) % q;
            txtHash = (txtHash * R + txt.charAt(i)) % q;
            int offset = i - M - 1;
            if ((patHash == txtHash) && check(txt, offset)) {
                return offset;
            }
        }
        return n;
    }

    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

}
