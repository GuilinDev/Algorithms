package com.guilin.leet;

public class Leet204CountPrimes {
	
	/*
	 * Count Primes: LC204
	 * Count the number of prime numbers less than a non-negative number, n
	 * 
	 * 1) How Many Primes Are There?
	 * 2) Sieve of Eratosthenes
	 */
	public int countPrimes(int n) {
        if(n <= 2){
            return 0;
        }
        
        Boolean[] pri = new Boolean[n];
        //Assume all integers smaller than n are primes
        for(int i = 2; i < n; i++){
            pri[i] = true;
        }
        
        for(int i = 2; i*i <= (n-1); i++){//iterate primes from 2
            if (pri[i]){
                for (int j = i + i; j < n; j += i){
                    pri[j] = false;//set those integers which are times of primes false
                }
            }
        }
        
        int count = 0;
        for(int i = 2; i < n; i++){
            if(pri[i]){
                count++;
            }
        }
        
        return count;
    }

}
