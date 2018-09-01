package TCPUDP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadTextClient {

	/**
	 * @param args
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException,
			IOException {

		// 1，创建客户端socket服务。
		Socket s = new Socket("192.168.1.200", 10006);

		// 2,客户端读取键盘录入的单词。
		BufferedReader bufr = new BufferedReader(new FileReader("temp\\client.txt"));

		// 3,明确目的，网络流。
		// BufferedWriter bufw = new BufferedWriter(new
		// OutputStreamWriter(s.getOutputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);

		// 4,明确源。来自于网络。
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(
				s.getInputStream()));

		String line = null;
		while ((line = bufr.readLine()) != null) {
			out.println(line);
		}
		
		
//		out.println("over");
		//告诉服务器端，客户端发送的数据结束了。
		s.shutdownOutput();

		
		//读取一次，服务端反馈的上传成功字样。
		String ok = bufIn.readLine();
		System.out.println(ok);
		s.close();
	}

}
