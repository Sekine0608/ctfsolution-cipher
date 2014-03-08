package util;

import java.math.BigInteger;

public class MathTool {

	/**
     * 素数２数を与えて積のオイラーのトーシェント関数の解を求める ((p-1)*(q-1)を求める)
     * @param p 素数
     * @param q 素数
     * @return φ (p*q)
     */
	
	public static BigInteger phiFunctionByPrimeNumber(BigInteger p, BigInteger q){
    	if(!p.gcd(q).equals(BigInteger.ONE)){ // pとqの最小公倍数が1以外のときtrue
    		throw new IllegalArgumentException("G.C.D. is not 1") ; // p, qは互いに素でなければならない G.C.M. は Greatest Common Measureの略で意味は最小公倍数、最小公倍数が１のとき互いに素であると言える。
    	}
    	BigInteger p_Sub1 = p.subtract(new BigInteger("1")) ; // p-1
        BigInteger q_Sub1 = q.subtract(new BigInteger("1")) ; // q-1
        BigInteger result = p_Sub1.multiply(q_Sub1); // (p-1) * (q-1) 
    	return result ;
    }
}
