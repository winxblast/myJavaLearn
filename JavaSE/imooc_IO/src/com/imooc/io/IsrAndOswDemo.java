package com.imooc.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IsrAndOswDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream in = new FileInputStream("e:\\java\\a.txt");
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");//默认使用项目的编码
		
		FileOutputStream out = new FileOutputStream("e:\\java\\a1.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		
//		int c;
//		while ((c = isr.read())!=-1) {
//			System.out.print((char) c);
//		}
		
		char[] cbuf = new char[8 * 1024];
		int c;
		//批量读取，放入cbuf这个字符数组，从第0个位置开始放置，最多放cbuf.length个
		//放回的是读到的字符个数
		while ((c=isr.read(cbuf, 0, cbuf.length))!=-1) {
			String s = new String(cbuf, 0, c);
			System.out.print(s);
			
			osw.write(cbuf, 0, c);
			osw.flush();
		}
			
		isr.close();
		osw.close();
	}

}
