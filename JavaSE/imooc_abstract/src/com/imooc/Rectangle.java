package com.imooc;

public class Rectangle extends Shape {

	@Override
	public double perimeter(double[] parameter) {
		// TODO Auto-generated method stub
		if(parameter.length==2){
			return 2*(parameter[0]+parameter[1]);
		}else{
			return 0;
		}
	}

	@Override
	public double area(double[] parameter) {
		// TODO Auto-generated method stub
		if(parameter.length==2){
			return parameter[0]*parameter[1];
		}else{
			return 0;
		}
	}

}
