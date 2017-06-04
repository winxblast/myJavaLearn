package com.imooc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 将要完成：
 * 1.通过Collection.sort()方法，对Integer泛型的List进行排序；
 * 2.对String泛型的List进行排序；
 * 3.对其他类型泛型的List进行排序，以Student类为例
 * @author WXB
 *
 */
public class CollectionsTest {

	/**
	 * 1.通过Collection.sort()方法，对Integer泛型的List进行排序；
	 * 创建一个Integer泛型的List，插入十个100以内的不重复的随机整数
	 * 调用Collections.sort（）方法对其进行排序
	 */
	public void testSort1(){
		List<Integer> integerList = new ArrayList<Integer>();
		//插入十个100以内的不重复的随机整数
		Random random = new Random();
		Integer k;
		for (int i=0;i<10;i++){
			do{
				k = random.nextInt(100);
			}while (integerList.contains(k));
			integerList.add(k);
			System.out.println("成功添加整数：" + k);
		}
		
		System.out.println("-----------排序前--------------");
		for (Integer integer : integerList) {
			System.out.println("元素：" + integer);
		}
		Collections.sort(integerList);
		System.out.println("-----------排序后--------------");
		for (Integer integer : integerList) {
			System.out.println("元素：" + integer);
		}
		
	}
	
	
	/**
	 * 2.对String泛型的List进行排序；
	 * 创建String泛型的List，添加三个乱序的String元素
	 * 调用sort（）方法，再次输出排序后的顺序
	 */
	public void testSort2(){
		List<String> stringList = new ArrayList<String>();
		stringList.add("microsoft");
		stringList.add("google");
		stringList.add("apple");
		System.out.println("----------排序前-----------");
		for (String string : stringList) {
			System.out.println("元素：" + string);
		}
		Collections.sort(stringList);
		System.out.println("----------排序后-----------");
		for (String string : stringList) {
			System.out.println("元素：" + string);
		}
	}
	
	/**
	 * 对String泛型List排序的升级版联系
	 * 1.创建完List<String>之后，往其中添加十条随机的字符串
	 * 2.每条字符串的长度为10以内的随机整数
	 * 3.每条字符串的每个字符都为随机生成的字符，字符可以重复
	 * 4.每条随机字符串不可重复
	 */
	public void testSortHomeWork(){
		List<String> stringList = new ArrayList<String>();
		Random random = new Random();
		String table = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "abcdefghijklmnopqrstuvwxyz";
		int k;
		int p;
		String randomString;
		StringBuffer sb;
		for (int i=0; i<10; i++){
			do{
				sb = new StringBuffer();
				k = random.nextInt(10)+1;
				for (int j=0; j<k; j++){
					p = random.nextInt(62);
					sb.append(table.substring(p, p+1));
				}
				randomString = sb.toString();
			}while(stringList.contains(randomString));
			stringList.add(randomString);
			System.out.println("成功添加了："+randomString);
		}
		System.out.println("----------排序前-----------");
		for (String string : stringList) {
			System.out.println("元素："+string);
		}
		Collections.sort(stringList);
		System.out.println("----------排序后-----------");
		for (String string : stringList) {
			System.out.println("元素："+string);
		}
	}
	
	/**
	 * 3.对其他类型泛型的List进行排序，以Student类为例
	 */
	public void testSort3(){
		List<Student> studentList = new ArrayList<Student>();
		Random random = new Random();
		studentList.add(new Student(random.nextInt(1000)+"","lucy"));//数字加空字符串自动转为字符串
		studentList.add(new Student(random.nextInt(1000)+"","alice"));
		studentList.add(new Student(random.nextInt(1000)+"","jack"));
		studentList.add(new Student(10000+"","tony"));//注意这个排序的问题，字符串的排序是一个一个字符依次比较的
		System.out.println("-------------排序前--------------");
		for (Student student : studentList) {
			System.out.println("学生："+student.id+student.name);
		}
		
		Collections.sort(studentList);
		System.out.println("-------------排序后（Comparable接口）--------------");
		for (Student student : studentList) {
			System.out.println("学生："+student.id+student.name);
		}
		
		Collections.sort(studentList, new StudentComparator());
		System.out.println("----------按姓名排序后（Comparator接口）-----------");
		for (Student student : studentList) {
			System.out.println("学生："+student.id+student.name);
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionsTest ct = new CollectionsTest();
//		ct.testSort1();
//		ct.testSort2();
//		ct.testSortHomeWork();
		ct.testSort3();
	}

}
