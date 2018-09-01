package testClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SplitFileTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
		/*
		 * 将一个文件按照指定的大小进行切割。
		 * 思路：
		 * 1，一个输入流关联源文件。
		 * 2，当缓冲的数据满足了指定的大小后，则新建一个目的地进行继续的数据存储。
		 * 3，给每一个碎片文件编号。
		 */
		File srcFile = new File("e:\\1.mp3");
		splitFile(srcFile);

	}

	



	public static void splitFile(File srcFile) throws IOException {
		
		
		FileInputStream fis = new FileInputStream(srcFile);
		
		FileOutputStream fos = null;
			
		byte[] buf = new byte[1024*1024];//创建一个1M的缓冲区。
		
		int len = 0;
		int count = 1;
		while((len=fis.read(buf))!=-1){
			
			fos = new FileOutputStream(new File("temp\\",(count++)+".part"));
			fos.write(buf,0,len);
			fos.close();
			
		}
		
		
		
		//将源文件的配置信息存储到一个文件中和碎片文件在一起。
		Properties prop = new Properties();		
		prop.setProperty("partcount", count+"");
		prop.setProperty("srcfilename", srcFile.getName());
		
		fos = new FileOutputStream(new File("temp\\",count+".properties"));
		
		prop.store(fos, "save partfiles info");
		
		fos.close();
		
		fis.close();
		
	}

}
