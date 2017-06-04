package com.imooc;

public class Dog extends Animal {
	
	int age = 3;
	
	static {
		System.out.println("Dog静态初始化块");
	}
	
	{
		age = 4;
		System.out.println("Dog普通初始化块，age："+age);
	}
	
	//子类构造方法定义
	public Dog() {
		System.out.println("Dog的构造方法初始化");
	}
	
	public void eat(){
		System.out.println("name:"+name+" age:"+age+" 狗具有吃骨头的能力");
		System.out.println("利用super调用父类的方法");
		super.eat();
	}

	@Override
	public String toString() {
		return "Dog [age=" + age + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (age != other.age)
			return false;
		return true;
	}
	
	
}
