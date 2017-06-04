package com.imooc;

public class PickupTruck extends Car {
	
	public PickupTruck(int id,String name,double price,int numPeople,
			double numGoods){
		this.id = id;
		this.name = name;
		this.price = price;
		this.numPeople = numPeople;
		this.numGoods = numGoods;
	}
	
	@Override
	public void printList() {
		// TODO Auto-generated method stub
		System.out.println(id+".\t"+name+"\t"+price+"元/天\t"+"载人："+numPeople+"人"
				+" 载货："+numGoods+"吨");
	}

}
