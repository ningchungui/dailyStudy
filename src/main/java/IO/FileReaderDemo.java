package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderDemo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

//		writeFile();
		
		/*
		 * 需求：读取一个已有的文本文件，将读到的数据打印到控制台(屏幕)。
		 * 思路：
		 * 1，应该是将硬盘的数据读去到内存中,使用输入流。
		 * 2，操作的数据是文本数据，应该使用字符流更为便捷。
		 * 3，即使输入，又是字符，应该是字符输入流：Reader
		 * 4，要用到字符输入流的哪个功能对象呢？操作文件的，FileReader 。
		 * 
		 */
		
		// 1，创建FileReader对象。 并通过构造函数明确数据源。
		// 创建读取对象，和数据源相关联。
		 
		FileReader fr = new FileReader("temp\\demo.txt");
		
		//2,调用Reader中的read方法，一次读取一个字符。
		/*int ch1 = fr.read();
		System.out.println("ch1="+ch1);
		int ch2 = fr.read();
		System.out.println("ch2="+ch2);
		int ch3 = fr.read();
		System.out.println("ch3="+ch3);
		int ch4 = fr.read();
		System.out.println("ch4="+ch4);
		int ch5 = fr.read();
		System.out.println("ch5="+ch5);*/
		
		//3,使用循环解决问题。
		int ch = 0;
		while((ch=fr.read())!=-1){
			System.out.println((char)ch);
		}
		
		
		//3,关闭资源。
		fr.close();
		
		
	}

	
	
	
	public static void writeFile() throws IOException{
		
		FileWriter fw = new FileWriter("temp\\demo.txt");
		
		fw.write("abcde");
		
		fw.close();
	}
}
