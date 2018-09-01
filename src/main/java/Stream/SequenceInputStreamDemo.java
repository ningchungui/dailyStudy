package Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class SequenceInputStreamDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
		
		/*
		 * 演示序列流。
		 * SequenceInputStream：
		 * 特地：
		 * 1，将多个源合并成一个源，
		 * 2，接收的是一个枚举接口对象。
		 */
		/*Vector<FileInputStream> v = new Vector<FileInputStream>();
		v.add(new FileInputStream("temp\\1.txt"));
		v.add(new FileInputStream("temp\\2.txt"));
		v.add(new FileInputStream("temp\\3.txt"));*/
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		for(int x=1; x<=3; x++){
			al.add(new FileInputStream("temp\\"+x+".txt"));
		}
		
		Enumeration<FileInputStream> en = Collections.enumeration(al);
		//多个源就变成了一个源。
		SequenceInputStream sis = new SequenceInputStream(en);
		
		//创建目的。
		FileOutputStream fos = new FileOutputStream("temp\\4.txt");
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		while((len=sis.read(buf))!=-1){
			fos.write(buf,0,len);
		}
		
		fos.close();
		sis.close();
		
	}

}
