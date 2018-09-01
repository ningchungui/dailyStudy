package TCPUDP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {

		/*
		 * 需求：基于tcp，创建一个客户端。
		 * 并将数据发送给服务端。
		 */
		System.out.println("客户端开启......");
		//1,必须先建立tcp的客户端socket服务。并指定要链接的主机和端口。
		Socket s = new Socket("192.168.1.200",10003);
		
		//2,通过socket获取socket流中的输出流对象。为了发送数据应获取输出流
		OutputStream out = s.getOutputStream();
		
		out.write("hi，server，哥们来了！".getBytes());
		
		
		s.close();
		
		System.out.println("客户端关闭......");
		
	}

}
