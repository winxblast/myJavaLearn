package com.imooc;

public class ChainTest {

	/**
	 * test1():抛出“喝大了”异常
	 * test2()：调用test1（），捕获“喝大了”异常，并且包装成运行时异常，继续抛出
	 * main方法中，调用test2（），尝试捕获test2（）方法抛出的异常
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChainTest ct = new ChainTest();
		try {
			ct.test2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void test1() throws DrunkException {
		throw new DrunkException("开车别喝酒！");
	}

	public void test2() throws RuntimeException {
		try {
			test1();
		} catch (DrunkException e) {
			// TODO Auto-generated catch block
			RuntimeException newExc = new RuntimeException("司机一滴酒，亲人两行泪");
			newExc.initCause(e);
			throw newExc;
		}
	}
	
}
