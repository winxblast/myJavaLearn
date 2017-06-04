package com.imooc;

//定义一个类
public class Telphone {
	//定义类属性
	private float screen;
	private float cpu;
	private float mem;
	int var;
	
	//定义构造方法
	public Telphone(){
		System.out.println("无参的构造方法执行了");
	}
	//有参的构造方法，方法重构
	public Telphone(float newScreen, float newCpu, float newMem){
		//判断输入内容合法性，保证程序安全
		if (newScreen<3.5){
			System.out.println("输入的screen参数范围有误，自动确定为3.5");
			screen = 3.5f;
		}else{
			screen = newScreen;
		}
		cpu = newCpu;
		mem = newMem;
		System.out.println("有参的构造方法执行了");
	}
	
	//封装类，getter、setter方法
	public float getScreen(){
		return screen;
	}
	public void setScreen(float screen){
		this.screen = screen;
	}
	
	public float getCpu() {
		return cpu;
	}
	public void setCpu(float cpu) {
		this.cpu = cpu;
	}
	public float getMem() {
		return mem;
	}
	public void setMem(float mem) {
		this.mem = mem;
	}
	//定义方法
	void call(){
		int localVar = 10;
		System.out.println("var:"+var);
		System.out.println("localVar:"+localVar);
		System.out.println("Telphone有打电话的功能");
	}
	
	void sendMessage(){
		System.out.println("screen:"+screen+",cpu:"+cpu+",mem:"+mem);
		System.out.println("Telphone有发短信的功能！");
	}
}
