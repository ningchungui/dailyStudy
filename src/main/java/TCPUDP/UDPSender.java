package TCPUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSender {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
		/*
		 * 需求：创建一个udp的发送端。
		 * 思路：
		 * 1，要先创建udp端点。也就是udp的socket。
		 * 2，将数据封装成数据包。
		 * 3，通过udp的端点将数据发送出去。就哦了。关闭资源
		 * 
		 */
		System.out.println("udp发送开始......");
		//1,创建udp的端点。
		DatagramSocket ds = new DatagramSocket(9527);
		
		//2,将数据封装成数据包。
		String str = "udp发送数据演示！";
		byte[] buf = str.getBytes();
		
		//2.1创建数据包对象。
		DatagramPacket dp = 
				new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.200"),10000);
		
		
		//3,使用udp的socket服务将数据包发出去。
		ds.send(dp);
		
		
		//4,关闭资源。
		ds.close();
		
		System.out.println("udp发送结束.....");
	}

}
