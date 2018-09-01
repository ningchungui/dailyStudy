package TCPUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiver {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * 需求：建立udp的接收端。
		 * 思路
		 * 1，必须有udp的端点。
		 * 2，接收数据，
		 * 3，并解析数据。
		 * 4，将数据打印出来看到，并结束接收动作。
		 */
		
		System.out.println("udp接收端开启.....");
		//1，创建一个udp的端点。注意：接收端一定要明确具体的端口。否则收不到数据。
		DatagramSocket ds = new DatagramSocket(10000);//从1000端口接受数据
		
		while(true)
		{
		//2，接收数据。 一般使用socket服务的动作完成。将数据存储到数据包对象中。
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		ds.receive(dp);//将接收到的数据存储到爆对象中
		
		//3,通过数据包对象的方法对数据进行解析。
		String ip = dp.getAddress().getHostAddress();
		int port = dp.getPort();
		
		String text = new String(dp.getData(),0,dp.getLength());
		
		System.out.println(ip+":"+port+"--"+text);
		
		//4,关闭资源。
		ds.close();
		System.out.println("udp接收端关闭.....");
		}
		
	}

}
