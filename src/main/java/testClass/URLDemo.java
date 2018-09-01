package testClass;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//		String str_url = "http://192.168.1.20:8080/myweb/1.html?name=lisi&age=20";
		String str_url = "http://192.168.1.20:8080/myweb/1.html";
		
		//将字符串url封装成URL对象。
		URL url = new URL(str_url);
		/*
		//通过url对象的getXXX方法将url路径中的所需的内容获取。
		System.out.println("getProtocol:"+url.getProtocol());
		System.out.println("getHost:"+url.getHost());
		System.out.println("getPort:"+url.getPort());
		System.out.println("getPath:"+url.getPath());
		System.out.println("getFile:"+url.getFile());
		System.out.println("getQuery:"+url.getQuery());
		*/
		
		//使用url的 openConnection方法获取对给资源的链接对象。
		URLConnection conn = url.openConnection();
		System.out.println(conn);
		
		InputStream in = conn.getInputStream();
		
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));
		
		
		
		
		
		
	}

}
