package com.imooc;

public class Initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telephone tel1 = new CellPhone();
		Telephone tel2 = new SmartPhone();
		
		tel1.call();
		tel1.sendMessage();
		tel2.call();
		tel2.sendMessage();
		
		IPlayGame ip1 = new SmartPhone();
		ip1.playGame();
		IPlayGame ip2 = new Psp();
		ip2.playGame();
		
		//tel2.playGame();//这里可以算是多态的一个体现，tel2引用了SmartPhone,
		//但是它的类型还是Telephone，所以没有playGame的方法。它只能实现SmartPhone为Telephone
		//重写的方法。
		
		IPlayGame ip3 = new IPlayGame(){

			@Override
			public void playGame() {
				// TODO Auto-generated method stub
				System.out.println("使用匿名内部类的方法实现接口方法1");
			}
			
		};
		ip3.playGame();
		
		new IPlayGame(){

			@Override
			public void playGame() {
				// TODO Auto-generated method stub
				System.out.println("使用匿名内部类的方法实现接口方法2");
			}
			
		}.playGame();
	}

}
