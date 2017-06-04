package com.ali;

import java.util.Scanner;

/**
 * 笔试题目截图见该工程文件夹内
 * @author WXB
 *
 */
public class Main1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		String pattern = in.next();
		if (filter(str,pattern))
			System.out.println("1");
		else
			System.out.println("0");
		
	}

	public static boolean filter(String str,String pattern){
		StringBuffer newStrB = new StringBuffer(str);
		StringBuffer newPatternB = new StringBuffer(pattern);
		int index1 = newPatternB.indexOf("?");
		int index2 = newPatternB.indexOf("*");
		while(index1!=-1 || index2!=-1 || newPatternB.length()>0){
			if ((index1!=-1 && index2==-1) || (index1!=-1 && index2!=-1 && index1<index2)){
				if (newPatternB.substring(0, index1).equals(newStrB.substring(0, index1))){
					newStrB.delete(0, index1+1);
					newPatternB.delete(0, index1+1);
				}else
					return false;
			}else if ((index2!=-1 && index1==-1) || (index1!=-1 && index2!=-1 && index2<index1)){
				if (newPatternB.substring(0, index2).equals(newStrB.substring(0, index2))){
					newPatternB.delete(0, index2+1);//加1，把*号删除
					newStrB.delete(0, index2);
					//需要匹配*号到下一个符号或到结尾的全部字符串
					int temp1 = newPatternB.indexOf("?");
					int temp2 = newPatternB.indexOf("*");
					int temp3 = newPatternB.length();
					int temp4;
					if (temp1==-1 && temp2==-1)
						temp4 = temp3;
					else if (temp1==-1)
						temp4 = temp2;
					else if (temp2==-1)
						temp4 = temp1;
					else
						temp4 = Math.min(temp1, temp2);
					
					int k;
					if (newStrB.indexOf(newPatternB.substring(0, temp4))>-1)
						k = newStrB.indexOf(newPatternB.substring(0, temp4));
					else
						return false;
					
					newStrB.delete(0, k);
				}else 
					return false;
			} else {
				//处理最后还剩一段字符串的比较
				if (newPatternB.toString().equals(newStrB.toString()))//StringBuffer类的equals方法不比较内容！！
					return true;
				else
					return false;
			}
			index1 = newPatternB.indexOf("?");
			index2 = newPatternB.indexOf("*");
		}
		
		return true;
	}
}

