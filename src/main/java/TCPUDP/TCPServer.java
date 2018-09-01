package TCPUDP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
		/*
		 * 创建服务端，接收客户端的数据。并打印在控制台上。
		 */
		System.out.println("服务端启动......");
		//1,创建tcp的服务端socket服务。服务端必须指定端口。
		ServerSocket ss = new ServerSocket(10003);
		
		//2,获取连接过来的客户端的对象。没有链接就会等，所以这个accept方法是阻塞式的
		Socket s = ss.accept();
		System.out.println(s.getInetAddress().getHostAddress()+"....connected");
		
		//3,通过客户端对象的读取流，读取客户端发来的数据。
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		
		System.out.println(new String(buf,0,len));
		
		s.close();
		
		ss.close();
		System.out.println("服务端关闭......");
		
		
		
	}

}
