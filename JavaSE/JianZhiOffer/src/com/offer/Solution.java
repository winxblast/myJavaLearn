package com.offer;

public class Solution {
    public int Fibonacci(int n) {
    	if (n==1 || n==2) {
    		return 1;
    	}
    	int f1 = 1;
    	int f2 = 1;
    	int f = 0;
    	for (int i=3; i<=n; i++) {
    		f = f1 +f2;
    		f1 = f2;
    		f2 = f;
    	}
    	return f;
    }
}