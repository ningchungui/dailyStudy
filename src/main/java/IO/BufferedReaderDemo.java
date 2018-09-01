package IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * 字符输入流缓冲区演示BufferedReader.
		 */
		//1，创建字符输入流对象。
		FileReader fr = new FileReader("temp\\buf.txt");
		
		//2，创建字符输入流缓冲区对象。
		BufferedReader bufr = new BufferedReader(fr);
		
		//3,使用BufferedReader的特有方法，一次读一行。
//		String line = bufr.readLine();
//		System.out.println(line);
		String line = null;
		while((line=bufr.readLine())!=null){
			System.out.println(line);
		}
		
		
		bufr.close();
	}

}
