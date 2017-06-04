package com.imooc.io;

import java.io.Serializable;

public class StudentSerializable implements Serializable {

	private String studentId;
	private String studentName;
	private int studentAge;
//	private transient int studentAge;//使用transient关键字，该元素不会进行jvm默认的序列化,可以自己主动完成序列化
	
	public StudentSerializable() {
		
	}
	
	
	public StudentSerializable(String studentId, String studentName, int studentAge) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
	}

	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	
	@Override
	public String toString() {
		return "StudentSerializable [studentId=" + studentId + ", studentName=" + studentName + ", studentAge="
				+ studentAge + "]";
	}
	
	//借用ArrayList中的方法来学习自行序列化和反序列化
	private void writeObject(java.io.ObjectOutputStream s)
	        throws java.io.IOException{
		s.defaultWriteObject();//把jvm能默认序列化的元素进行序列化
		s.writeInt(studentAge);//自己完成studentAge的序列化
	}
	private void readObject(java.io.ObjectInputStream s)
	        throws java.io.IOException, ClassNotFoundException {
		s.defaultReadObject();//把jvm能默认反序列化的元素进行反序列化操作
		this.studentAge = s.readInt();//自己完成studentAge的反序列化操作
	}
	
}
