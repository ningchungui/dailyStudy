package Stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * 操作基本数据类型值的流对象。
		 * 
		 * 
		 * write(int):将一个整数的四个字节中的最低字节写入到目的地。
		 * print(int);将一个整数的表现形式写入到目的地。你写的是什么，到目的地就是什么。
		 * writeInt(int);将一个整数的四个字节写入到目的地。保证数据字节的原样性。
		 * 
		 */
		
//		writeData();
		
		readData();
	}

	public static void readData() throws IOException {
		
		
		FileInputStream fis = new FileInputStream("temp\\data.txt");
		
		DataInputStream dis = new DataInputStream(fis);
		
		int num = dis.readInt();
		System.out.println(num);
		
		dis.close();
	}

	public static void writeData() throws IOException {
		
		FileOutputStream fos = new FileOutputStream("temp\\data.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeInt(353);//print(353);
		
		dos.close();
		
	}

}
