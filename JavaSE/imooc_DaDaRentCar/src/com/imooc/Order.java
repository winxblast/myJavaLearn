package com.imooc;
import java.util.Scanner;

public class Order {
	Car[] car =new Car[6];
	
	public void initial(){
		car[0] = new Coach(1,"奥迪A4",500,4);
		car[1] = new Coach(2,"马自达6",400,4);
		car[2] = new PickupTruck(3,"皮卡雪6",450,4,2);
		car[3] = new Coach(4,"金龙",800,20);
		car[4] = new Truck(5,"松花江",400,4);
		car[5] = new Truck(6,"依维柯",1000,20);
		//这里处理的可能不是特别完美，毕竟这个car类可以按需生成，即客户需要哪几种就生成哪几种
		//当然，这些车辆信息正常情况下是存在数据库中的，这里为了完成这个题目也只能这样了
		for(Car c:car){
			c.printList();
		}
	}
	
	public int[] generateOrder(){
		int[] orderList = new int[7];//这里第0个存放订单天数！！！
		Scanner input = new Scanner(System.in);
		System.out.println("请输入您要租汽车的数量：");
		int numCar = input.nextInt();
		for(int i=0;i<numCar;i++){
			System.out.println("请输入第"+(i+1)+"辆车的序号：");
			int k = input.nextInt();
			orderList[k]++;
		}
		System.out.println("请输入订单天数：");
		orderList[0] = input.nextInt();
		
		input.close();
		return orderList;
	}
	
	public void showBill(int[] orderList){
		int totalPeople = 0;
		double totalGoods = 0;
		double totalPrice = 0;
		
		System.out.println("您的账单：");
		
		//显示载人车的租用情况
		System.out.println("***可载人的车有：");
		for(int i=0;i<6;i++){
			if(car[i].numPeople!=0 && orderList[i+1]!=0){
				System.out.print(car[i].name+"\t");
				totalPeople += car[i].numPeople*orderList[i+1];
			}
		}
		System.out.println("共载人："+totalPeople+"人");
		
		//显示载货车的租用情况
		System.out.println("***可载货的车有：");
		for(int i=0;i<6;i++){
			if(car[i].numGoods!=0 && orderList[i+1]!=0){
				System.out.print(car[i].name+"\t");
				totalGoods += car[i].numGoods*orderList[i+1];
			}
		}
		System.out.println("共载货："+totalGoods+"吨");
		
		//显示租金信息
		for(int i=0;i<6;i++){
			totalPrice += car[i].price*orderList[i+1];//不做判断直接乘，反正没有订单就是0
		}
		totalPrice = totalPrice*orderList[0];//每日价格乘以租用天数
		System.out.println("***租车总价格："+totalPrice+"元");
	}
	
}
