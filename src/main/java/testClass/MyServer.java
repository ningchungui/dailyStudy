package testClass;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) throws IOException {
		
		
		/*
		 * 常见的客户端和服务端：
		 * 
		 * 客户端：浏览器。
		 * 服务端：Tomcat
		 * 
		 * 1，浏览器访问Tomcat服务器。
		 * 浏览器到底做了什么事情呢？
		 * 客户端：浏览器。
		 * 服务器：自定义。
		 */
		
		//1,创建服务器端对象。
		ServerSocket ss = new ServerSocket(9090);
		
		//2,获取客户端对象。
		Socket s = ss.accept();
		
		System.out.println(s.getInetAddress().getHostAddress()+"......connected");
		
		//3,获取socket流中的输入流。
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String str = new String(buf,0,len);
		System.out.println(str);
		
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		out.println("<font color='red' size='7'>欢迎光临!</font>");
		
		s.close();
		ss.close();
		
		/*
		HTTPX 协议的请求消息。
		
		GET / HTTP/1.1   //请求行， 请求方式   资源路径  协议版本
		请求头的属性信息。键值对组成。
		Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/x-shockwave-flash
		Accept-Language: zh-cn
		Accept-Encoding: gzip, deflate
		User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)
		Host: 192.168.1.20:9090
		Connection: Keep-Alive
		空行。用于区分请求信息和请求体。
		请求体。
		*/
	}
}
