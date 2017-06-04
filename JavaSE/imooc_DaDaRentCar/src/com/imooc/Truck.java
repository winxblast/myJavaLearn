package com.imooc;

public class Truck extends Car {
	
	public Truck(int id,String name,double price,double numGoods){
		this.id = id;
		this.name = name;
		this.price = price;
		this.numGoods = numGoods;
	}
	
	@Override
	public void printList() {
		// TODO Auto-generated method stub
		System.out.println(id+".\t"+name+"\t"+price+"元/天\t"+"载货："+numGoods+"吨");
	}

}
