package com.imooc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class UDPServerThread extends Thread {
	// 和本线程相关的Socket,数据报
	DatagramSocket socket = null;
	DatagramPacket packet = null;
	byte[] data = null;

	public UDPServerThread(DatagramPacket packet) {
		this.packet = packet;
		this.data = packet.getData();
	}
	
	// 线程执行操作，响应客户端请求
	@Override
	public void run() {
		try {
			// 4.读取数据
			String info = new String(data, 0, packet.getLength());
			InetAddress address = packet.getAddress();
			int port = packet.getPort();
			System.out.println("我是服务器，客户端说：" + info+address+port);
			
			/*
			 * 向客户端响应数据
			 */
			// 1.定义客户端的地址、端口号、数据
//			InetAddress address = packet.getAddress();
//			int port = packet.getPort();
			byte[] data2 = "欢迎您！".getBytes();
			// 2.创建数据报，包含响应的数据信息
			DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
			socket = new DatagramSocket();
			// 3.响应客户端
			socket.send(packet2);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
