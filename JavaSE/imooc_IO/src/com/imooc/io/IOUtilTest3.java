package com.imooc.io;

import java.io.File;
import java.io.IOException;

public class IOUtilTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			IOUtil.copyFile(new File("e:\\java\\fileutils.java"), new File("e:\\java\\FileUtils1.java"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
