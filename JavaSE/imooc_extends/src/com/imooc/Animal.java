package com.imooc;

public class Animal {
	public int age = 1;
	public String name;
	
	static {//静态初始化块
		System.out.println("Animal静态初始化块");
	}
	
	{//初始化块
		age = 2;
		System.out.println("Animal普通初始化块，age："+age);
	}
	
	//构造方法
	public Animal(){
		System.out.println("Animal的构造方法初始化了");
	}
	
	public void eat(){
		System.out.println("name:"+name+" age:"+age+" 动物具有吃东西的能力");
	}
}
