package TCPUDP;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadTextServer {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 1,创建服务端socket服务。
		ServerSocket ss = new ServerSocket(10006);

		// 2,获取socket对象。
		Socket s = ss.accept();
		System.out.println(s.getInetAddress().getHostAddress()
				+ "....connected");

		// 3，明确源，网络。Socket输入流。
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(
				s.getInputStream()));

		// 4,明确目的，文件
		PrintWriter pw = new PrintWriter(new FileWriter("temp\\server.txt"), true);

		// 5,就是熟悉的读写过程。
		String line = null;
		while ((line = bufIn.readLine()) != null) {
			
//			if("over".equals(line)){
//				break;
//			}
			pw.println(line.toUpperCase());
		}

		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("上传成功");
		
		s.close();
		ss.close();
	}

}
