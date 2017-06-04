package com.ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 笔试题目截图见该工程文件夹内
 * @author WXB
 *
 */
public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }

	}
	
	// write your code here
    public static int resolve(String expr) {
    	Stack<Integer> st = new Stack<Integer>();
    	int num = 0;
    	int temp1;
    	int temp2;
    	for (int i=0; i<expr.length(); i++){
    		String exprChar = expr.substring(i,i+1);
    		try{
    			Integer integer1 = Integer.valueOf(exprChar);
    			//入栈
    			st.push(integer1);
    			num++;
    			if (num>16)
    				return -2;
    		} catch (Exception e){
    			if (exprChar.equals(" "))
    				continue;
    			else if (exprChar.equals("^")){
    				//出栈加一
    				temp1 = st.pop()+1;
    				st.push(temp1);
    			}else if (exprChar.equals("+")){
    				//相加
    				if (num>1){
    					temp1 = st.pop();
        				temp2 = st.pop();
        				st.push(temp1+temp2);
        				num--;
    				}else {
    					return -1;
    				}
    				
    			}else if (exprChar.equals("*")){
    				//相乘
    				if (num>1){
    					temp1 = st.pop();
        				temp2 = st.pop();
        				st.push(temp1*temp2);
        				num--;
    				}else {
    					return -1;
    				}
    				
    			}
    		}
    		
    	}
    	
        return st.pop();
    }

}
