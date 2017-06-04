package com.imooc.io;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {

	public static void main(String[] args) throws Exception {
		
		String s = "慕课ABC";
		byte[] byte1 = s.getBytes();
		for (byte b : byte1) {
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		
		System.out.println();
		
		byte[] byte2 = s.getBytes("gbk");
		for (byte b : byte2) {
//			System.out.print(Integer.toHexString(b & 0xff)+" ");
			System.out.print(b+" ");
		}

	}

}
