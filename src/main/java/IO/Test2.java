package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * 获取键盘录入数据，并保存在硬盘上。
		 */
		
		//读取键盘。
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		//读取目的。
		BufferedWriter bufw = new BufferedWriter(new FileWriter("temp\\test2.txt"));
		
		String line = null;
		while((line=bufr.readLine())!=null){
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
			if("over".equals(line)){
				break;
			}
		}
		
		bufw.close();
		bufr.close();
	}

}
