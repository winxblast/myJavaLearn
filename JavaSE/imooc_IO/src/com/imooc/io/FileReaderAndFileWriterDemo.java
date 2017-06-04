package com.imooc.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderAndFileWriterDemo {

	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("e:\\java\\a.txt");
		FileWriter fw = new FileWriter("e:\\java\\a2.txt");
//		FileWriter fw = new FileWriter("e:\\java\\a2.txt",true);
		
		char[] cBuffer = new char[2056];
		int c;
		while ((c=fr.read(cBuffer, 0, cBuffer.length))!=-1) {
			fw.write(cBuffer, 0, c);
			fw.write(cBuffer);
			fw.flush();
		}
		fr.close();
		fw.close();
	}

}
