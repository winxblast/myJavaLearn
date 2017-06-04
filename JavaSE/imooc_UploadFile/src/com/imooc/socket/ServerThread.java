package com.imooc.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.imooc.dao.FileDao;
import com.imooc.dao.UserDao;
import com.imooc.model.File;
import com.imooc.model.User;
import com.imooc.util.CommandTransfer;

public class ServerThread extends Thread {

	private Socket socket = null;
	
	public ServerThread() {
		
	}
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	// 线程执行的操作，响应客户端的请求
	@Override
	public void run() {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			CommandTransfer commandTransfer = (CommandTransfer) ois.readObject();
			commandTransfer = executeCommand(commandTransfer);
			
//			socket.shutdownInput();
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(commandTransfer);
			oos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public CommandTransfer executeCommand(CommandTransfer commandTransfer) {
		UserDao userDao = new UserDao();
		FileDao fileDao = new FileDao();
		User user = null;
		User userfind = null;
		File file = null;
		
		switch (commandTransfer.getCmd()) {
		case "login":
			user = (User) commandTransfer.getData();
			userfind = userDao.query(user.getUsername());
			if (userfind.getUsername() != null) {
				if (user.getPassword().equals(userfind.getPassword())) {
					commandTransfer.setFlag(true);
					commandTransfer.setResult("登录成功！");
				} else {
					commandTransfer.setFlag(false);
					commandTransfer.setResult("密码错误！");
				}
			} else {
				commandTransfer.setFlag(false);
				commandTransfer.setResult("用户不存在！");
			}
			break;
		case "signup":
			user = (User) commandTransfer.getData();
			userfind = userDao.query(user.getUsername());
			if (userfind.getUsername() == null) {
				userDao.addUser(user);
				commandTransfer.setFlag(true);
				commandTransfer.setResult("注册成功！");
			}else {
				commandTransfer.setFlag(false);
				commandTransfer.setResult("用户已存在！");
			}
			break;
		case "upload":
			file = (File) commandTransfer.getData();
			fileDao.addFile(file);
			commandTransfer.setFlag(true);
			commandTransfer.setResult("文件上传成功！");
			break;
		default :
			commandTransfer.setFlag(false);
			commandTransfer.setResult("程序员写错程序啦！");
		}
		
		commandTransfer.setData(null);//要是有文件再传回去会占用带宽
		return commandTransfer;
		
	}
	
	public static void main(String[] args) {
		//测试
		ServerThread st = new ServerThread();
		CommandTransfer ct = new CommandTransfer();
		ct.setCmd("signup");
		User user = new User();
		user.setUsername("zhaoyue");
		ct.setData(user);
		ct = st.executeCommand(ct);
		System.out.println(ct.getResult());
	}
}







