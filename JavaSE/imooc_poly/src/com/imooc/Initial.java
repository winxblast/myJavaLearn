package com.imooc;

public class Initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal obj1 = new Animal();
		Animal obj2 = new Dog();//父类的引用是可以指向子类对象的
		Animal obj3 = new Cat();
		
		obj1.eat();//方法的多态
		obj2.eat();
		obj2.shoot();//体会eat和shoot的区别，一个用的是Dog中的，一个用的是Animal中的方法
		obj3.eat();
		//obj2.watchDoor();//这个做法是错误的
		
		
	}

}
