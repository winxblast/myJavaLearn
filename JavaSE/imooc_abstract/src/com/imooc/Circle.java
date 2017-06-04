package com.imooc;
import java.lang.Math;

public class Circle extends Shape {

	@Override
	public double perimeter(double[] parameter) {
		// TODO Auto-generated method stub
		if(parameter.length==1){
			return 2*Math.PI*parameter[0];
		}else{
			return 0;
		}
	}

	@Override
	public double area(double[] parameter) {
		// TODO Auto-generated method stub
		if (parameter.length==1){
			return Math.PI*parameter[0]*parameter[0];
		}else{
			return 0;
		}
	}

}
