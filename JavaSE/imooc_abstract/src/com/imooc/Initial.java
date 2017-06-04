package com.imooc;

public class Initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape rec = new Rectangle();
		Shape cir = new Circle();
		double[] p1 = {2,3};
		double[] p2 = {1};
		System.out.println("长方形的周长为："+rec.perimeter(p1));
		System.out.println("长方形的面积为："+rec.area(p1));
		System.out.println("圆形的周长为："+cir.perimeter(p2));
		System.out.println("圆形的面积为："+cir.area(p2));
	}

}
