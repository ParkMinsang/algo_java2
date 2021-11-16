package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class boj1629 {
    static BigInteger a,b,c;
    static BigInteger bo = new BigInteger("1");
    static BigInteger bt = new BigInteger("2");
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        a = new BigInteger(st.nextToken());
        b = new BigInteger(st.nextToken());
        c = new BigInteger(st.nextToken());

        System.out.println(fastPow(a, b));
    }

    static BigInteger fastPow(BigInteger a, BigInteger m){
        if(m.equals(bo)) return a.mod(c);
        if(m.mod(bt).equals(bo)) return fastPow(a, m.subtract(bo)).multiply(a).mod(c);
        BigInteger half = fastPow(a, m.divide(bt)).mod(c);
        return half.multiply(half).mod(c);
    }
}
