package TCPUDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * 频繁获取键盘录入的数据。并发送给接收端。
		 */
		
		//1,建立udpsocket服务端点。
		DatagramSocket ds = new DatagramSocket(8888);
		
		//2,明确数据，将数据封装成数据包。
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		while((line=bufr.readLine())!=null){
			if("over".equals(line))
				break;
			
			byte[] buf = line.getBytes();
			DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.200"),10001);
			
			ds.send(dp);
		}
		
		ds.close();
		
		
	}

}
