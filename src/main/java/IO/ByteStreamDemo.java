package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

//		writeFile();
		readFile2();
		
		
	}
	
	

	public static void readFile2() throws IOException {
		
		FileInputStream fis = new FileInputStream("temp\\fos.txt");
		
//		System.out.println(fis.available());//获取文件的字节数。
//		byte[] buf = new byte[fis.available()];//以它作为缓冲区的长度是不合适
//		fis.read(buf);
//		System.out.println(new String(buf));
		//创建一个缓冲区。缓冲读到的字节。
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=fis.read(buf))!=-1){
			System.out.println(new String(buf,0,len));
		}
		
		fis.close();
	}



	public static void readFile() throws IOException {
		
		/*
		 * 读取一个文件。
		 * 找一个能操作文件的字节输入流。
		 */
		FileInputStream fis = new FileInputStream("temp\\fos.txt");
		
		int by = 0;
		while((by=fis.read())!=-1){
			System.out.println(by);
		}
		
		
		//关闭资源。
		fis.close();
		
		
	}



	public static void writeFile() throws IOException {
		
		/*
		 * 将内存中的数据写到硬盘上。 
		 * 1，输出。
		 * 2，文件。
		 * 3，因为要演示字节流所以要找一个能处理文件的字节输出流。
		 */
		FileOutputStream fos = new FileOutputStream("temp\\fos.txt");
		
		//使用流对象write方法，将数据写入到目的地。
		byte[] buf = "abc".getBytes();
		fos.write(buf);//直接可以将数据写入到目的地。
		
		//关闭资源。
		fos.close();
		
		
	}

}
