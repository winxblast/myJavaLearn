package com.imooc;

public class Coach extends Car {
	
	public Coach(int id,String name,double price,int numPeople){
		this.id = id;
		this.name = name;
		this.price = price;
		this.numPeople = numPeople;
	}
	
	@Override
	public void printList() {
		// TODO Auto-generated method stub
		System.out.println(id+".\t"+name+"\t"+price+"元/天\t"+"载人："+numPeople+"人");
	}

}
