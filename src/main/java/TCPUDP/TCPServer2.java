package TCPUDP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer2 {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {

		
		//1,创建tcp服务端的socket服务，并监听一个端口。
		ServerSocket ss = new ServerSocket(10004);
		
		//2,获取客户端对象。
		Socket s = ss.accept();
		System.out.println(s.getInetAddress().getHostAddress()+"......connected");
		
		//3,通过客户端对象获取socket流中的输入流。
		InputStream in = s.getInputStream();
		
		//4,定义缓冲区，读取数据。
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));
		
		//5,通过客户端对象获取socket流中的输出流。
		OutputStream out = s.getOutputStream();
		
		out.write("哈哈，我已收到！哦也！".getBytes());
		
		s.close();
		
		ss.close();
		
	}

}
