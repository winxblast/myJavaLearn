package com.imooc;

public abstract class Car {
	public int id;//该型车辆的编号
	public String name;//车辆名称
	public double price;//每辆车一天租金价格
	public int numPeople;//车辆载人数量，0表示不能载人，货车相当于不能载人吧
	public double numGoods;//车辆载货数量，正数，0表示不能载货
	
	public abstract void printList();
}
