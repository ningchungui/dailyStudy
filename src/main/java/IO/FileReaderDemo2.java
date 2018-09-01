package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * read(char[]);
		 * 
		 * 
		 */
		//1,创建读取流对象和数据源关联。
		FileReader fr = new FileReader("temp\\demo.txt");
		
		//2,创建一个字符数组。用于存储读到字符数据。
		char[] buffer = new char[1024];//一般定义的都是1024的整数倍。
	
		
		//3,调用读取流的read(char[])，将读到的字符存储到字符数组中。
		/*int len1 = fr.read(buffer);
		System.out.println("len1="+len1+";"+new String(buffer));
		int len2 = fr.read(buffer);
		System.out.println("len2="+len2+";"+new String(buffer));
		int len3 = fr.read(buffer);
		System.out.println("len3="+len3+";"+new String(buffer));
		int len4 = fr.read(buffer);
		System.out.println("len4="+len4+";"+new String(buffer));*/
		
		//4,循环。
		int len = 0;
		while((len=fr.read(buffer))!=-1){
			System.out.println(new String(buffer,0,len));
		}
		
		
		
		fr.close();
	}

}
