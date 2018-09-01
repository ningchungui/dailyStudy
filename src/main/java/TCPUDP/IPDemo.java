package TCPUDP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {

		
//		InetAddress ip = InetAddress.getLocalHost();
		InetAddress ip = InetAddress.getByName("www.sina.com.cn");//"www.sina.com.cn"是域名地址，故要获取其网络地址
		
		System.out.println("ip:"+ip.getHostAddress());//一个网络地址可能对应多台服务器
		System.out.println("name:"+ip.getHostName());
		
	}

}
