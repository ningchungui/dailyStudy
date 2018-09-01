package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyPicTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
		copyPic3();
		
	}

	/*
	 * 该方法不可以用，效率低。
	 */
	public static void copyPic3() throws IOException {
		
		FileInputStream fis = new FileInputStream("temp\\0.bmp");		
		FileOutputStream fos = new FileOutputStream("temp\\3.bmp");
		int by = 0;
		
		while((by=fis.read())!=-1){
			fos.write(by);
		}
		 
		fos.close();
		fis.close();
	}

	public static void copyPic2() throws IOException {
		FileInputStream fis = new FileInputStream("temp\\0.bmp");		
		FileOutputStream fos = new FileOutputStream("temp\\2.bmp");
		
		BufferedInputStream bufis = new BufferedInputStream(fis);
		BufferedOutputStream bufos = new BufferedOutputStream(fos);
		
		byte[] buf = new byte[1024];
		int by = 0;
		
		while((by=bufis.read())!=-1){
			bufos.write(by);
		}
		
		bufos.close();
		bufis.close();
		
		
		
	}

	/*
	 * 复制一个图片。
	 * 1，即有读又有写。
	 * 2，还是非文本数据。
	 * 使用了到了字节流中用于操作文件的对象。
	 */
	public static void copyPic() throws IOException {
		
		//1，明确数据源和数据目的。 
		FileInputStream fis = new FileInputStream("temp\\0.bmp");		
		FileOutputStream fos = new FileOutputStream("temp\\1.bmp");
		
		//2,自定义缓冲区。字节流
		byte[] buf = new byte[1024];
		
		int len = 0;
		
		while((len=fis.read(buf))!=-1){
			fos.write(buf,0,len);
		}
		
		
		fos.close();
		fis.close();
	}

}
