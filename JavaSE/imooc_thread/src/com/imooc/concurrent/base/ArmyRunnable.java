package com.imooc.concurrent.base;

/**
 * 这里教程通过表现隋唐演义中军队交战，关键英雄人物对事件的影响等来讲解多线程的概念
 * 
 * @author WXB 军队线程，模拟作战双方的行为
 */
public class ArmyRunnable implements Runnable {

	//volatile保证了线程可以正确读取其他线程写入的值
	//由于可见性问题，不声明volatile就不能正常读取，可以参考JMM（Java内存模型，happens-before原则）
	volatile boolean keepRunning = true;

	@Override
	public void run() {
		while (keepRunning) {
			// 发动5连击
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]");
				//yield()方法让出处理器时间，可以让所有线程去竞争cpu时间，下次该谁进攻还不一定呢
				Thread.yield();
			}
			
		}
		
		System.out.println(Thread.currentThread().getName()+"结束了战斗！");
		
	}

}
