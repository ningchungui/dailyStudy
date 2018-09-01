package Stream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
		/*
		 * RandomAccessFile:
		 * 1,既可以读取，有可以写入。
		 * 2,只对文件操作。
		 * 3,内部维护了一个大型的byte数组，将字节输入流和字节输出流进行封装。
		 * 4,通过索引的方式对数组中的元素进行操作，获取和设置索引的方法是getFilePointer,seek。
		 * 5,随机的访问的原理：就是通过操作索引的方法对指针进行自定义的指定位置来进行读写。
		 * 
		 * 对于被随机读取的数据最好有规律。
		 */
		
//		writeFile();
		readFile();
	}
	
	
	

	public static void readFile() throws IOException {
		
		RandomAccessFile raf = new RandomAccessFile("temp\\raf.txt","r");
		
		//想要获取王五的信息。
		raf.seek(8*1);
		
		byte[] buf = new byte[4];
		raf.read(buf);
		String name = new String(buf);
		System.out.println("name="+name);
		
		int age = raf.readInt();
		System.out.println("age="+age);
		
		raf.close();
		
	}




	public static void writeFile() throws IOException {
		
		//1，创建随机访问文件的对象。 文件不存在，会创建，文件存在，不创建。
		RandomAccessFile raf = new RandomAccessFile("temp\\raf.txt","rw");
		
		//2,将数据写入到文件中。姓名，年龄。
//		raf.write("张三".getBytes());
//		raf.writeInt(97);		
//		raf.write("李四".getBytes());
//		raf.writeInt(99);
		System.out.println(raf.getFilePointer());
		
//		raf.seek(16);//指定位置。随机写入。
		
		raf.write("赵六".getBytes());
		raf.writeInt(108);
		raf.close();
		
	}

}
