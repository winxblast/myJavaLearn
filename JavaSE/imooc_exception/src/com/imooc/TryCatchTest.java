package com.imooc;

public class TryCatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TryCatchTest tct = new TryCatchTest();
		int result = tct.test();
		System.out.println("test方法执行完毕！返回值为："+result);
		int result2 = tct.test2();
		System.out.println("test2执行完毕！");
		
		int result3 = tct.test3();
		System.out.println("我想大声告诉你test3运行完了，返回值为："+result3);
		
	}

	/*
	 * divider(除数)
	 * result(结果)
	 * try-catch捕获while循环
	 * 每次循环divider减一，result=result+100/divider
	 * 如果捕获异常，打印输出“抛出异常了！！”，返回-1
	 * 否则返回result
	 */
	public int test(){
		int divider=10;
		int result = 100;
		try{
			while(divider>-1){
				result = result + 100/divider;
				divider--;
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("循环抛出异常了！！！");
			return -1;
		}
	}
	
	/*
	 * divider(除数)
	 * result(结果)
	 * try-catch捕获while循环
	 * 每次循环divider减一，result=result+100/divider
	 * 如果捕获异常，打印输出“抛出异常了！！”，返回999
	 * 否则返回result
	 * finally:打印输出这是finally！！同时打印输出result的值
	 */
	public int test2(){
		int divider = 10;
		int result = 100;
		try{
			while(divider>-1){
				result = result + 100/divider;
				divider--;
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("test2循环抛出异常了！！！");
			return result=999;
		}finally{
			System.out.println("这里是test2的finally！！");
			System.out.println("我是test2的result，我的值是："+result);
		}
	}
	
	/*
	 * divider(除数)
	 * result(结果)
	 * try-catch捕获while循环
	 * 每次循环divider减一，result=result+100/divider
	 * 如果捕获异常，打印输出“抛出异常了！！”
	 * 否则返回result
	 * finally:打印输出这是finally！！同时打印输出result的值
	 * 最后返回1111
	 */
	public int test3(){
		int divider = 10;
		int result = 100;
		try{
			while(divider>-1){
				result = result + 100/divider;
				divider--;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("test2循环抛出异常了！！！");
		}finally{
			System.out.println("这里是test2的finally！！");
			System.out.println("我是test2的result，我的值是："+result);
		}
		System.out.println("我是test3，我运行完了~~");
		return 1111;
	}
}
