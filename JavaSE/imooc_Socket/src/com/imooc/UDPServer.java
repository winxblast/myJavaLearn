package com.imooc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * 服务器端，实现基于UDP的用户登录
 */
public class UDPServer {
	public static void main(String[] args) throws IOException {
		/*
		 * 接收客户端发送的数据
		 */
		//1.创建服务器端的DatagramSocket，指定端口
		DatagramSocket socket = new DatagramSocket(8800);
		//2.创建数据报，用于接收客户端发送的数据
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		//3.接收客户端发送的数据
		System.out.println("***服务器已经启动，等待客户端发送数据***");
		//记录客户端数量
		int count = 0;
		//循环监听
		while (true) {
			socket.receive(packet);//此方法在接收到数据报之前会一直阻塞
			//创建一个新线程
			UDPServerThread udpServerThread = new UDPServerThread(packet);
			//启动线程
			udpServerThread.start();
			
			count++;
			System.out.println("客户端的数量："+count);
//			InetAddress address = socket.getInetAddress();
//			System.out.println("客户端的IP地址是："+address.getHostAddress());
		}
//		//4.关闭资源
//		socket.close();
	}
}
