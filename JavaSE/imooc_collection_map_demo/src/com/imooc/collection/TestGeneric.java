package com.imooc.collection;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

	/**
	 * 带有泛型——Course的List类型属性
	 */
	public List<Course> courses;
	
	public TestGeneric () {
		this.courses = new ArrayList<Course>();
	}

	/**
	 * 测试添加
	 * @param args
	 */
	public void testAdd() {
		Course cr = new Course("1","大学语文");
		courses.add(cr);
		//泛型集合中，不能添加泛型规定的类型及其子类型以外的对象，否则编译器直接报错
		//要是没规定泛型，可以添加其他对象，则编译器不会报错
//		courses.add("能够添加一些奇怪的东西呢？？");
		Course cr2 = new Course("2","java基础");
		courses.add(cr2);
	}
	
	/**
	 * 测试循环遍历
	 * @param args
	 */
	public void testForEach () {
		for (Course cr:courses) {
			System.out.println(cr.id+":"+cr.name); 
		}
	}
	
	/**
	 * 泛型集合可以添加子类型的对象实例
	 * @param args
	 */
	public void testChild (){
		ChildCourse ccr = new ChildCourse();
		ccr.id = "3";
		ccr.name = "我是子类型的课程对象实例~~";
		courses.add(ccr);
	}
	
	/**
	 * 泛型不能使用基本类型
	 * @param args
	 */
	public void testBasicType() {
//		List<int> list = new ArrayList<int>();不能使用基本类型
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);//基本类型被自动装箱为包装类
		System.out.println("基本类型必须使用包装类作为泛型！"+list.get(0));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGeneric tg = new TestGeneric();
		tg.testAdd();
		tg.testForEach();
		tg.testChild();
		tg.testForEach();
		tg.testBasicType();
	}

}
