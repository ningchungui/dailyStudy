package TCPUDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TransClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {

		/*
		 * 需求：通过客户端给服务器端发送单词数据，服务端将单词转成大写返回客户端。
		 * 如果客户端发送over，则客户端结束发送。其实就是创建了一个大写服务器。
		 */
		
		//1，创建客户端socket服务。
		Socket s = new Socket("192.168.1.200",10005);
		
		//2,客户端读取键盘录入的单词。
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		//3,明确目的，网络流。
//		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		
		//4,明确源。来自于网络。
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		
		String line = null;
		while((line=bufr.readLine())!=null){
			
			if("over".equals(line)){
				break;
			}
			
			out.println(line);
			
			String str = bufIn.readLine();
			System.out.println("trans : "+str);
		}
		
		s.close();
		
		
	}

}
/*
该列子出现的问题
现象：客户端和服务端都在默默的等待
为什么呢
因为客户端和服务端都有阻塞式方法，这些方法没有读到结束标记，那么就一直等待而导致两端都在等待。

*/
