package testClass;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyBrowser {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		
		//1,创建客户端对象。
		Socket s = new Socket("192.168.1.103",8080);
		
		
		//2,将socket输出流封装到打印流中。将浏览器发送的信息通过该流打印到服务器端。
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		out.println("GET /myweb/1.html HTTP/1.1");
		out.println("Accept: */*");
		out.println("Host: 192.168.1.20:8080");
		out.println("Connection: close");
		out.println();
		out.println();

		
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));
		
		
		s.close();
		
		
		/*
		http的应答消息。
		 
		HTTP/1.1 200 OK  //应答行   http协议版本  应答状态码  应答描述信息
		应答消息的属性信息。键值对。
		Server: Apache-Coyote/1.1
		Accept-Ranges: bytes
		ETag: W/"79-1364954414830"
		Last-Modified: Wed, 03 Apr 2013 02:00:14 GMT
		Content-Type: text/html
		Content-Length: 79
		Date: Wed, 03 Apr 2013 03:01:35 GMT
		Connection: close
		空行。
		应答的主体内容
		<h1>这是我的网页</h1>

		<font color="red" size="7">我的首页资源演示页面</font>

		*/
	}

}
