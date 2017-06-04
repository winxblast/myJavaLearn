package com.imooc.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializableDemo1 {

	public static void main(String[] args) throws Exception {
		
		String filename = "demo/obj.dat";

		//对象的序列化
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
//		StudentSerializable stu = new StudentSerializable("10001", "jack", 20);
//		oos.writeObject(stu);
//		oos.flush();
//		oos.close();
		
		//反序列化
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
		StudentSerializable stu = (StudentSerializable) ois.readObject();
		System.out.println(stu);
		ois.close();
		
	}

}
