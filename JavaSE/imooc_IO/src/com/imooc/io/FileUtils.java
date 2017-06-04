package com.imooc.io;

import java.io.File;
import java.io.IOException;

//列出File的常用操作比如过滤、遍历等
public class FileUtils {

	/**
	 * 列出指定目录下（包括子目录）的所有文件
	 * @param dir
	 * @throws IOException
	 */
	public static void listDirectory(File dir) throws IOException {
		if(!dir.exists()){
			throw new IllegalArgumentException("目录:"+dir+"不存在");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir+"不是目录");
		}
		
//		//返回字符串数组，包含文件文件夹名称，不含子目录下文件
//		String[] fileNames = dir.list();
//		for (String string : fileNames) {
//			System.out.println(string);
//		}
		
		//如果要遍历子目录下的内容，就需要构造File对象做递归操作，File提供了直接返回File的api
		File[] files = dir.listFiles();//返回的是子目录（文件）的抽象
		if (files!=null && files.length>0) {
			for (File file : files) {
				if (file.isDirectory()) {
					//递归
					listDirectory(file);
				} else {
					System.out.println(file);
				}
			}
		}
	}
}
