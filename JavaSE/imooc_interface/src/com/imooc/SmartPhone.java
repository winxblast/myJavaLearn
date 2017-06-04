package com.imooc;

public class SmartPhone extends Telephone implements IPlayGame{

	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("智能机用语音发短信");
	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub
		System.out.println("智能机用语音打电话");
	}

	@Override
	public void playGame() {
		// TODO Auto-generated method stub
		System.out.println("智能机具有了玩游戏的功能");
	}

}
