package com.imooc.io;

import java.io.File;
import java.io.IOException;

public class IOUtilTest4 {

	//测试BufferedInputStream和BufferedOutputStream
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			long start;
			long end;
			
			//以下测试结果又很多种变化，可以尝试将两种方法调换先后位置来执行比较
			start = System.currentTimeMillis();
			IOUtil.copyFile(new File("e:\\java\\1.mp3"), new File("e:\\java\\3.mp3"));
			end = System.currentTimeMillis();
			System.out.println("字节批量（数组）"+(end - start));
			
			//虽然有了缓冲，但是在内存中还是一个一个字节操作，所以还是慢
			start = System.currentTimeMillis();
			IOUtil.copyFileByBuffer(new File("e:\\java\\1.mp3"), new File("e:\\java\\2.mp3"));
			end = System.currentTimeMillis();
			System.out.println("使用缓冲"+(end - start));
			
			start = System.currentTimeMillis();
			IOUtil.copyFileByBufferAndArray(new File("e:\\java\\1.mp3"), new File("e:\\java\\4.mp3"));
			end = System.currentTimeMillis();
			System.out.println("使用缓冲+字节数组"+(end - start));
			
			//下面这个按字节来的太慢了，就不要再试了
//			start = System.currentTimeMillis();
//			IOUtil.copyFileByByte(new File("e:\\java\\1.mp3"), new File("e:\\java\\4.mp3"));
//			end = System.currentTimeMillis();
//			System.out.println("单字节"+(end - start));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
