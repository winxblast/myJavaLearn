package com.imooc;
import java.util.Scanner;

public class Rent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.println("欢迎使用答答租车系统");
		System.out.println("您是否要租车：1是； 0否");
		
		if(input.nextInt()==1){
			System.out.println("您可租车的类型及其价目表：");
			System.out.println("序号\t汽车名称\t租金\t\t容量");
			
			Order order = new Order();
			order.initial();
			
			int[] orderList = order.generateOrder();
			order.showBill(orderList);
		}
		input.close();
		System.out.println("谢谢您的使用！再见！");
	}

}
