package solution;

import java.math.BigInteger;

import util.MathTool;

/**
 * 
 * @author sekinenaoki
 * 
 * ハンドル名CIPHERさんのサイト(http://gbb60166.jp/cipher.htm)の情報を用いて,　javaAPIを活用し
 * http://ksnctf.sweetduet.info/problem/16の解法を簡潔に書く
 * 
 * 基本的に
 * http://gbb60166.jp/cipher/mathemat.htm
 * http://gbb60166.jp/cipher/example.htm
 * あたりを参考にしている
 * 
 * 出力された文字列をコピーし、pythonを使って "出力文字列".decode("hex")
 * でフラグを求める 
 */

public class Solution {

	BigInteger publicKey_e = QuestionValues.E ;
	BigInteger publicKey_n = QuestionValues.N ;
	BigInteger encoded_c = QuestionValues.C ;
	BigInteger p = QuestionValues.P ;
	BigInteger q = QuestionValues.Q ;

	public String excute(){

		//オイラーのファイ関数を用いて φ(p*q)を求める
    	BigInteger phi = MathTool.phiFunctionByPrimeNumber(p, q) ;

    	//φ(p*q)を法とするときの、publicKey_eの逆元を求める。その逆元が秘密鍵(privateKey_d)になる。
    	BigInteger privateKey_d = publicKey_e.modInverse(phi) ;
    	
    	//publicKey_nを法とするときの、encoded_cのprivateKey_d乗を求める。
    	BigInteger answer = encoded_c.modPow(privateKey_d, publicKey_n) ;
		
    	return answer.toString();
		
	}
}
