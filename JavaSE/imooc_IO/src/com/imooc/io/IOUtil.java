package com.imooc.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {

	/**
	 * 读取指定文件内容，按照16进制输出到控制台
	 * 并且每输出10个byte换行
	 * @param fileName
	 * @throws IOException 
	 */
	public static void printHex(String fileName) throws IOException {
		FileInputStream in = new FileInputStream(fileName);
		
		int b;
		int i = 1;
		while ((b=in.read())!=-1) {
			if (b <= 0xf) {
				System.out.print("0");//单个16进制数补0
			}
			System.out.print(Integer.toHexString(b)+" ");
			if (i++%10==0) {
				System.out.println();
			}
		}
		in.close();
	}
	
	public static void printHexByByteArray(String fileName) throws IOException {
		FileInputStream in = new FileInputStream(fileName);
		byte[] buf = new byte[20 * 1024];
		
		//从in中批量读取字节，放到buf这个字节数组中，从第0个位置开始放，最多放buf.length个，返回的是读到字节的个数
		int bytes = in.read(buf, 0, buf.length);
		int j = 1;
		for (int i = 0; i < bytes; i++) {
			if (buf[i] <= 0xf){
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(buf[i])+" ");
			if (j++%10 == 0) {
				System.out.println();
			}
		}
	}
	
	/**
	 * 文件拷贝，字节批量读取
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFile(File srcFile, File destFile) throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件："+srcFile+"不存在");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile+"不是文件");
		}
		
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		try {
			byte[] buf = new byte[8 * 1024];
			int b;
			while ((b=in.read(buf, 0, buf.length ))!=-1) {
				out.write(buf, 0, b);
				out.flush();//最好加上
			}
			
		} finally {
			// TODO: handle finally clause
			in.close();
			out.close();
		}
	}
	
	/**
	 * 进行文件拷贝，利用带缓冲的字节流
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByBuffer(File srcFile, File destFile) throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件："+srcFile+"不存在");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile+"不是文件");
		}
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile), 10*1024);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile), 10*1024);
		try {
			int c;
			while ((c=bis.read())!=-1) {
				bos.write(c);
				
			}
			bos.flush();//刷新缓冲区
			
		} finally {
			// TODO: handle finally clause
			bis.close();
			bos.close();
		}
	}
	
	/**
	 * 进行文件拷贝，利用带缓冲的字节流
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByBufferAndArray(File srcFile, File destFile) throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件："+srcFile+"不存在");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile+"不是文件");
		}
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile), 10*1024);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile), 10*1024);
		try {
			int c;
			byte[] buf = new byte[8 * 1024];
			while ((c=bis.read(buf, 0, buf.length))!=-1) {
				bos.write(buf, 0, c);
				
			}
			bos.flush();//刷新缓冲区
			
		} finally {
			// TODO: handle finally clause
			bis.close();
			bos.close();
		}
	}
	
	/**
	 * 单字节，不带缓冲进行文件拷贝
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByByte(File srcFile, File destFile) throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件："+srcFile+"不存在");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile+"不是文件");
		}
		
		FileInputStream fis = new FileInputStream(srcFile);
		FileOutputStream fos = new FileOutputStream(destFile);
		
		try {
			int c;
			while((c = fis.read())!=-1) {
				fos.write(c);
				fos.flush();
			}
			
		} finally {
			// TODO: handle finally clause
			fis.close();
			fos.close();
		}
		
	}
}




