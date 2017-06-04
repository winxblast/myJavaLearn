package com.imooc.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.imooc.socket.ServerThread;

public class Server {

	public static void main(String[] args) {
		try {
			//创建服务器端socket，绑定端口并监听
			ServerSocket serverSocket = new ServerSocket(8889);
			Socket socket = null;
			int count = 0;//记录客户端数量，不然服务器端没有输出就不好判断状态了
			System.out.println("*****服务器即将启动，等待客户端连接*****");
			
			//循环监听客户端的连接
			while (true) {
				//调用accept()方法开始监听，等待客户端的连接，accept方法会阻塞，需要多线程的办法
				socket = serverSocket.accept();
				
				//创建一个新的线程
				ServerThread serverThread = new ServerThread(socket);
				//启动线程
				serverThread.start();
				
				count++;//统计客户端的数量
				System.out.println("客户端的数量："+count);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
