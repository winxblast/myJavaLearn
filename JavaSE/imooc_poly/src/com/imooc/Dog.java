package com.imooc;

public class Dog extends Animal {
	public void eat(){//这是eat的方法重写，没有改变返回值，方法类型和传递的参数
		System.out.println("狗是吃肉的");
	}
	
	public void shoot(int a){//这不叫shoot的方法重写
		System.out.println("狗会汪汪叫");
	}
	
	public void shoot(){//体会把这个方法注释掉后的异同
		System.out.println("狗会汪汪叫");
	}
	
	public void watchDoor(){
		System.out.println("狗具有看门的能力");
	}
}
