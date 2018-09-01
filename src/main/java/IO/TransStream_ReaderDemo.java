package IO;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransStream_ReaderDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * 演示转换流 字节-->字符。
		 */
		
		readFile();
	}

	public static void readFile() throws IOException {
		
		
		//1,读取已有的字符文件。为指定过编码。
//		FileReader fr = new FileReader("temp\\default.txt");
//		char[] buf = new char[1024];
//		int len = fr.read(buf);
//		String str = new String(buf,0,len);
//		System.out.println(str);	
//		int ch1 = fr.read();
//		System.out.println((char)ch1);
//		int ch2 = fr.read();
//		System.out.println((char)ch2);
//		int ch3 = fr.read();
//		System.out.println(ch3);
//		fr.close();
		
		
		//2,既然是存储到硬盘的都是字节数据。干脆就使用字节流读不就哦了吗。
		//不行，因为读取到的都是字节数据，没有查表，无法获取对应的文字。
		//所以应该将字节转成字符数据，使用转换流完成 InputStreamReader. 
//		FileInputStream fis = new FileInputStream("temp\\trans_default.txt");
//		InputStreamReader isr = new InputStreamReader(fis,"gbk");//使用的默认的字符集。或者使用gbk的码表
//		int ch1 = isr.read();
//		System.out.println((char)ch1);
//		int ch2 = isr.read();
//		System.out.println((char)ch2);
//		int ch3 = isr.read();
//		System.out.println(ch3);
//		isr.close();
		
		/*FileInputStream fis = new FileInputStream("temp\\default.txt");
		int ch1 =fis.read();		
		System.out.println(ch1);
		int ch2 =fis.read();		
		System.out.println(ch2);
		int ch3 =fis.read();		
		System.out.println(ch3);
		int ch4 =fis.read();		
		System.out.println(ch4);
		int ch5 =fis.read();		
		System.out.println(ch5);
		fis.close();
		*/
		
		
		
		FileInputStream fis = new FileInputStream("temp\\trans_U8.txt");
		InputStreamReader isr = new InputStreamReader(fis,"utf-8");
		char[] buf = new char[1024];
		int len = isr.read(buf);
		String str = new String(buf,0,len);
		System.out.println(str);
		isr.close();
	}
	

}
