package TCPUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * 接收发送端的数据，并打印到屏幕上。
		 */
		//1，建立接收端的udpsocket服务，必须明确端口号。
		DatagramSocket ds = new DatagramSocket(10001);
		while(true){
		
		//2,创建数据包。
		byte[] buf  = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		
		//3,使用接收方法将接收到的数据存储到数据包中。
		ds.receive(dp);
		
		//4,对数据进行解析。
		String ip = dp.getAddress().getHostAddress();
		String text = new String(dp.getData(),0,dp.getLength());
		System.out.println(ip+":"+text);
		}
//		ds.close();
		
		
	}

}
