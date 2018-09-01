package TCPUDP;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadPicClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket s = new Socket("192.168.1.200",10007);
		
		
		//客户端要读取图片。
		FileInputStream fis = new FileInputStream("temp\\1.jpg");
		
		OutputStream out = s.getOutputStream();
		
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=fis.read(buf))!=-1){
			out.write(buf,0,len);
		}
		
		//告诉服务端已经写完。
		s.shutdownOutput();
		
		InputStream in = s.getInputStream();
		//读取上传成功字样。
		byte[] bufIn = new byte[1024];
		int lenIn = in.read(bufIn);
		System.out.println(new String(bufIn,0,lenIn));
		
		fis.close();
		s.close();
		
	}

}
