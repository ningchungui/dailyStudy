package TCPUDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
//import java.net.SocketException;

public class ChatDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		DatagramSocket send = new DatagramSocket(9999);
		DatagramSocket rece = new DatagramSocket(10002);
		
		new Thread(new Send(send)).start();//开启线程
		new Thread(new Rece(rece)).start();
	}
}

/*
 * 群聊程序，一边发一边收。 使用两个内容：1，使用广播 192.168.1.255，使用多线程。
 */

// 建立发送的任务。
class Send implements Runnable {

	private DatagramSocket ds;

	public Send(DatagramSocket ds) {
		super();
		this.ds = ds;
	}

	//@Override
	public void run() {
		
		try {
			
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			
			String line = null;
			while((line=bufr.readLine())!=null){
				
				
				byte[] buf = line.getBytes();
				DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.255"),10002);
				
				ds.send(dp);
				
				if("88".equals(line)){
					break;
				}
			}
			
			ds.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}

// 建立接收任务。
class Rece implements Runnable {

	private DatagramSocket ds;

	public Rece(DatagramSocket ds) {
		super();
		this.ds = ds;
	}

	//@Override
	public void run() {

		while(true){
			
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf,buf.length);
			
			try {
				ds.receive(dp);//将拿到的数据放到dp中
				
				
				String ip  = dp.getAddress().getHostAddress();//先拿IP地址
				String text = new String(dp.getData(),0,dp.getLength());
				
				System.out.println(ip+"::"+text);
				if("88".equals(text)){
					System.out.println(ip+".....离开聊天室!!!");
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			
			
		}
		
	}

}
