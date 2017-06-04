package com.imooc;

public class Initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
		
		dog.age = 5;
		dog.name = "huan";
		dog.eat();
		System.out.println(dog);
		
		Dog dog2 = new Dog();
		if (dog.equals(dog2)) {
			System.out.println("两个对象是相等的");
		}else {
			System.out.println("两个对象是不相等的");
		}
	}

}
