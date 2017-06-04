package com.imooc;

public class InitailTelphone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telphone phone = new Telphone();
		Telphone phone2 = new Telphone(5.5f, 1.4f, 2.0f);
		phone.sendMessage();
		
		/*
		//给实例对象赋值
		phone.screen = 5.5f;
		phone.cpu = 2.0f;
		phone.mem = 2.5f;
		//再次调用对象的方法
		phone.sendMessage();
		phone.call();
		*/
		
		phone2.sendMessage();
		System.out.println(phone2.getScreen());
	}

}
