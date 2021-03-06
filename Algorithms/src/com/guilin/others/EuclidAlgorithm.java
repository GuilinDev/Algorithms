package com.guilin.others;

public class EuclidAlgorithm {

	public static void main(String[] args) {
		System.out.println("Two numbers should be non negative:");
		int n1 = 29, n2 = 16;
		System.out.println("The common greatest divisor of two nonnegative numbers "
				  + n1 + " and " + n2 + " is: " + EuclidAlgorithm.gcd(n1, n2));
		System.out.println("The common greatest divisor of two nonnegative numbers "
				  + n1 + " and " + n2 + " is: " + EuclidAlgorithm.gcdNonRecersive(n1, n2));
	}
	
	private static int gcd(int p, int q){
		if (q == 0){
			return p;
		}
		int r = p % q;
		return gcd(q, r);
	}
	
	private static int gcdNonRecersive(int p, int q){
		int r = 0;
		while (q != 0){
			r = p % q;
			p = q;
			q = r;
		}
		return p;		
	}

}
