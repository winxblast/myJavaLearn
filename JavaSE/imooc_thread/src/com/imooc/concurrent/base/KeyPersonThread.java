package com.imooc.concurrent.base;

/*
 * 战争中关键人物类
 */
public class KeyPersonThread extends Thread {

	public void run() {
		System.out.println(Thread.currentThread().getName()+"开始了战斗！");
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"左突右杀，攻击隋军···");
		}
		
		System.out.println(Thread.currentThread().getName()+"结束了战斗！");
	}
}
