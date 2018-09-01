package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopytTextTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * 需求： 将c盘中的文本文件复制到d盘中。
		 *
		 * 思路：
		 * 1，既然是复制，必须要有源。
		 * 2，对源就是读取，并将读到的字符数据存储到目的中。
		 * 3，即用到了读，又用到了写。而且还是字符。说明使用Reader Writer
		 * 4，操作都是文件，使用的应该是FileReader，FileWriter.
		 *
		 */
		copyText2();
		
	}

	public static void copyText2() {
		
		/*
		 * 复制使用数组缓冲区完成。
		 * 
		 */
		
		//1，创建读取流和写入流。
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("temp\\CopytTextTest.java");
			fw = new FileWriter("temp\\demo_copy2.txt");
			
			//定义一个缓冲区数组。
			char[] buf = new char[1024];
			
			int len = 0;
			while((len=fr.read(buf))!=-1){
				fw.write(buf,0,len);//读取几个就写几个。节约存储空间
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			if(fw!=null)
				try {
					fw.close();
				} catch (Exception e2) {
					throw new RuntimeException("写入关闭失败");
				}
			if(fr!=null)
				try {
					fr.close();
				} catch (Exception e2) {
					throw new RuntimeException("读取关闭失败");
				}
		}
	}

	public static void copyText() throws IOException {
		
		//1,创建一个字符读取流和指定的源相关联。
		FileReader fr = new FileReader("temp\\CopytTextTest.java");
		
		//2,确定数据存储的目的。
		FileWriter fw = new FileWriter("temp\\demo_copy.txt");
		
		//3,读一个写出去。有很多字符，需要循环。 当读取动作返回-1，说明结束。
		int ch = 0;
		while((ch=fr.read())!=-1){
			fw.write(ch);
		}
		
		//4,关闭资源。 
		fw.close();
		fr.close();
	}

}
