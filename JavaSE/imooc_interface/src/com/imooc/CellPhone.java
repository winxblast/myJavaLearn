package com.imooc;

public class CellPhone extends Telephone {

	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("功能机用键盘打电话");
	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub
		System.out.println("功能机用键盘发短信");
	}

}
