package com.imooc;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AliJava {

/** 请完成下面这个函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static long caculateSubs(int n, int[][] array) {
        long count = 0;
               
        for (int k=0; k<n;k++){
        	
        	int[] choose = new int[n];
        	
        	if (array[0][k]==1){
        		choose[k] = 1;
        	}else{
        		continue;
        	}
        	
        	int i = 0;
        	int j = 0;
        	for (i=1; i<n;i++){
        		
        		for ( j=0; j<n; j++){
        			if(array[i][j]==1 && choose[j]!=1){
        				choose[j]=1;
        				break;
        			}        			
        		}
        		if(j==n-1 && choose[j]!=1){
    				break;
    			}
        		
        	}
        	if(!(j==n-1 && choose[j]!=1)){
        		count++;
    		}
        }
        return count;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long res;
            
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        int _array_rows = 0;
        int _array_cols = 0;
        _array_rows = _n;
        _array_cols = _n;
        
        int[][] _array = new int[_array_rows][_array_cols];
        for(int _array_i=0; _array_i<_array_rows; _array_i++) {
            for(int _array_j=0; _array_j<_array_cols; _array_j++) {
                _array[_array_i][_array_j] = in.nextInt();
                
            }
        }
        
        if(in.hasNextLine()) {
          in.nextLine();
        }
  
        res = caculateSubs(_n, _array);
        System.out.println(String.valueOf(res));  

    }
}