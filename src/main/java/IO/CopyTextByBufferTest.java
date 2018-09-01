package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTextByBufferTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * 通过缓冲区对文本文件进行复制。
		 */
		
		copyTextByBuffer();
	}

	public static void copyTextByBuffer() throws IOException {
		
		//1,创建流对象和缓冲区对象。
		FileReader fr = new FileReader("temp\\buf.txt");
		BufferedReader bufr = new BufferedReader(fr);
		
		FileWriter fw = new FileWriter("temp\\buf_copy.txt");
		BufferedWriter bufw = new BufferedWriter(fw);
		
		//2,对一行文本进行读写。
		String line = null;
		/*
		BufferedReader  bufr =null;
		BufferedWriter  bufw=null;
		try{
			
				bufr=new BufferedReader(new FileReader("BufferedWriterDemo.java"));
				bufw=new Bufferedwriter(new FileWriter("BufferedWriterDemo.java"));
		
		
		}
		
		*/
		
		while((line=bufr.readLine())!=null){
			bufw.write(line);
			bufw.newLine();//注意newLine并不返回回车符
			bufw.flush();
		}
		
		bufw.close();
		bufr.close();
		
		
	}

}
