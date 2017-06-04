package com.imooc.io;

import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		File file = new File("E:\\java\\imooc");
////		System.out.println(file.exists());
//		if (!file.exists()) {
//			file.mkdirs();
//		} else {
//			file.delete();
//		}
		File file1 = new File("E:\\java\\one\\two");
		file1.mkdirs();
	}

}
