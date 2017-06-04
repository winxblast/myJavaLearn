package com.imooc;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BorrowSystem {
	
	Book[] books = new Book[4];
	
	/*
	 * 初始化构造函数，将书名及序号载入，Book类可以看做一个结构体
	 */
	public BorrowSystem(){
		books[0] = new Book(1,"西游记");
		books[1] = new Book(2,"水浒传");
		books[2] = new Book(3,"三国演义");
		books[3] = new Book(4,"红楼梦");
	}
	
	public void findBook () {
		
		try {
			int i = getKind();
			if (i==1){
				nameFind();
			} else {//输入时已经判断异常了，这里就直接认为是2了
				idFind();
			}
		} catch(WrongOrderException e){
			findBook();
		} catch(NoBookException e){
			findBook();
		}
	}
	
	/**
	 * 获取图书查找方式，并适当处理异常
	 * @return
	 * @throws WrongOrderException
	 */
	public int getKind() throws WrongOrderException {
		int kind = 0;
		System.out.println("请输入命令：1-按照名称查找图书；2-按照序号查找图书");
		Scanner input = new Scanner(System.in);
		try {
			kind = input.nextInt();
			input.nextLine();
			if (kind==1 || kind==2) {
				return kind;
			} else {
				throw new WrongOrderException();
			}
		} catch (InputMismatchException e) {//非数字输入的异常也要抛出
			throw new WrongOrderException();
		} finally {
			//input.close();
		}
	}
	
	public void nameFind () throws NoBookException {
		System.out.println("输入图书名称：");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		//input.close();
		for (Book b:books){
			if (name.equals(b.name)){
				System.out.println("book:ID"+b.id+" "+b.name);
				return;
			}
		}
		throw new NoBookException();
	}
	
	public void idFind () throws NoBookException {
		System.out.println("输入图书序号：");
		Scanner input = new Scanner(System.in);
		try {
			int id = input.nextInt();
			input.nextLine();
			for (Book b:books){
				if (id==b.id){
					System.out.println("book:"+b.name);
					return;
				}
			}
			throw new NoBookException();
		} catch (InputMismatchException e){
			System.out.println("输入错误！请根据要求输入序号！");
			idFind();
		} finally {
			//input.close();
		}
	}
	
	
}
