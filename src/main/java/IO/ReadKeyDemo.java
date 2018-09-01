package IO;

import java.io.IOException;
import java.io.InputStream;

public class ReadKeyDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//获取System中标准的输入流对象。
		InputStream in = System.in;
		
//		int ch1 = in.read();
//		System.out.println("ch1="+ch1);
//		int ch2 = in.read();
//		System.out.println("ch2="+ch2);
//		int ch3 = in.read();
//		System.out.println("ch3="+ch3);
//		int ch4 = in.read();
//		System.out.println("ch4="+ch4);
		
//		System.out.println((int)'\r');
//		System.out.println((int)'\n');
		
		//in.close();可以不用关闭，如果关闭，就无法继续获取了。
	}

}
