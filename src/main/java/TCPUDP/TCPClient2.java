package TCPUDP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient2 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {

		/*
		 * 需求：客户端将数据发送到服务端，服务端收到后，将应答的数据反馈给客户端。
		 */
		
		//1,创建tcp客户端socket服务。“192.168.1.200”是指要连接的主机地址
		Socket s = new Socket("192.168.1.200",10004);
		
		//2,获取socket流的输出流对象。
		OutputStream out = s.getOutputStream();
		
		//3,将数据写入到的socket流。
		out.write("hi,server,哥们又来了！".getBytes());//流是操作字节的，故要获取其字节数据
		
		//4,获取服务端发挥的数据，需要用到socket流中的输入流。
		InputStream in = s.getInputStream();
		
		//5,创建缓冲区，读取数据。
		byte[] buf = new byte[1024];		
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));
		
		s.close();
		
	}

}
