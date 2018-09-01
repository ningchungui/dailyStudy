package TCPUDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TransServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//1,创建服务端socket服务。
		ServerSocket ss = new ServerSocket(10005);
		
		//2,获取socket对象。
		Socket s = ss.accept();
		System.out.println(s.getInetAddress().getHostAddress()+"....connected");
		
		//3，明确源，网络。Socket输入流。
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//4,明确目的，网络，socket输出流。
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);//printWriter能接受字符流和字节流，true表示自动刷新
		
		//5,就是熟悉的读写过程。
		String line = null;
		while((line=bufIn.readLine())!=null){///
			
			out.println(line.toUpperCase());

		}
		
		
		s.close();
		ss.close();
	}

}
