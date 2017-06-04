package com.imooc.socket;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.imooc.model.File;
import com.imooc.model.User;
import com.imooc.util.CommandTransfer;

public class ClientSocket {

	private Scanner input = new Scanner(System.in);
	private Socket socket = null;
	
	public void start() {
		System.out.println("*****欢迎使用文件上传器*****");
		boolean exit = true;
		while (exit) {
			System.out.println("**********");
			System.out.println("1.登录");
			System.out.println("2.注册");
			System.out.println("3.退出");
			System.out.println("请选择：");
			switch (input.next()) {
			case "1":
				login();
				break;
			case "2":
				signup();
				break;
			case "3":
				System.out.println("再见！");
				exit = false;
				break;
			default:
				System.out.println("输入错误，请重新选择！");
				break;
			}
		}
	}
	
	private void login() {
		String username = null;
		String password = null;
		User user = null;

		while (true) {
			System.out.println("**********");
			System.out.println("请输入用户名：");
			username = input.next();
			System.out.println("请输入密码：");
			password = input.next();
			user = new User();
			user.setUsername(username);
			user.setPassword(password);
			
			try {
				socket = new Socket("127.0.0.1", 8889);
				CommandTransfer commandTransfer = new CommandTransfer();
				commandTransfer.setCmd("login");
				commandTransfer.setData(user);
				sendData(commandTransfer);
				commandTransfer = getData();
				System.out.println(commandTransfer.getResult());
				if (commandTransfer.getFlag()) {
					break;
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				closeAll();
			}
			
		}
		
		upload(user);
	}
	
	private void signup() {
		String username = null;
		String password = null;
		String password2 = null;
		User user = null;

		while (true) {
			while (true) {
				System.out.println("**********");
				System.out.println("请输入用户名：");
				username = input.next();
				System.out.println("请输入密码：");
				password = input.next();
				System.out.println("请再次输入密码：");
				password2 = input.next();
				if (password.equals(password2)) {
					user = new User();
					user.setUsername(username);
					user.setPassword(password);
					break;
				} else {
					System.out.println("两次输入的密码不一致，请重新输入！");
				}
			}
			try {
				socket = new Socket("127.0.0.1", 8889);
				CommandTransfer commandTransfer = new CommandTransfer();
				commandTransfer.setCmd("signup");
				commandTransfer.setData(user);
				sendData(commandTransfer);
				commandTransfer = getData();
				System.out.println(commandTransfer.getResult());
				if (commandTransfer.getFlag()) {
					break;
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				closeAll();
			} 
		}

	}
	
	private void upload(User user) {
		
		FileInputStream fio = null;
		BufferedInputStream bis = null;
		File file = null;
		
		while (true) {
			try {
				System.out.println("**********");
				System.out.println("请输入上传文件的绝对路径（如：e:/imooc/dog.jpg）：");
				String filePath = input.next();
				fio = new FileInputStream(filePath);
				byte[] fcontent = new byte[fio.available()];
				bis = new BufferedInputStream(fio);
				bis.read(fcontent);
				file = new File();
				String fileName = filePath.substring(filePath.lastIndexOf('/') + 1);
				file.setFname(fileName);
				file.setUsername(user.getUsername());
				file.setFcontent(fcontent);
				
				socket = new Socket("127.0.0.1", 8889);
				CommandTransfer commandTransfer = new CommandTransfer();
				commandTransfer.setCmd("upload");
				commandTransfer.setData(file);
				sendData(commandTransfer);
				commandTransfer = getData();
				System.out.println(commandTransfer.getResult());
				if (commandTransfer.getFlag()) {
					break;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (bis != null) {
						bis.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				closeAll();
			}
		}
	}
	
	private void sendData(CommandTransfer commandTransfer) {
		
		ObjectOutputStream oos = null;
		try {
			// 对象序列化传输
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(commandTransfer);
			oos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
//		finally {
//			try {
//				if (oos != null) {
//					oos.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
	}
	
	private CommandTransfer getData() {
		
		ObjectInputStream ois = null;
		CommandTransfer commandTransfer = null;
		try {
			// 反序列化对象
			ois = new ObjectInputStream(socket.getInputStream());
			commandTransfer = (CommandTransfer) ois.readObject();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
//		finally {
//			try {
//				if (ois != null) {
//					ois.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		return commandTransfer;
	}
	
	private void closeAll() {
		try {
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}






