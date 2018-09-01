package IO;

import java.io.IOException;
import java.io.Reader;

/**
 * 自定义字符读取缓冲区。
 * @author Administrator
 *
 */
public class MyBufferedReader extends Reader {

	private Reader r;
	/*
	 * 其实缓冲区无非就是封装了一个数组对象。
	 * 对外提供了对数组中元素的操作。
	 */
	//定义一个字符数组。作为缓冲存在。
	private char[] buf = new char[1024];
	//定义了两个变量，一个记录数组的角标。一个记录存储到数组中字符的个数。
	private int index = 0;
	private int count = 0;

	public MyBufferedReader(Reader r) {
		super();
		this.r = r;
	}
	
	
	/**
	 * 提供一个一次读一个字符的方法。并返回读到字符。如果读到结尾返回-1.
	 * 注意：该方法其实是从缓冲区中进行读取。
	 * @throws IOException 
	 */
	
	public int myRead() throws IOException{
		
		//当count等于0时，才需要去源中取数据。
		if(count==0){
		//通过流对象的read(char[])方法从源中取一批数据进数组缓冲区,用count记录存储的个数。
			count = r.read(buf);
			
			//每获取一次数据，就要将角标归零。
			index = 0;
		}
		if(count<0)
			return -1;
		char ch =buf[index];
		index++;
		count--;
		
		return ch;
	}
	
	/**
	 * 提供一个一次读一行的方法。内部其实使用的是本类的myRead()方法
	 * 完成的，将读到的字符进行缓冲，当读取到的行终止符时，将存储的
	 * 字符作为字符串返回。
	 * @throws IOException 
	 */
	public String myReadLine() throws IOException{
		
		/*
		 * 其中也需要定义缓冲区。就是用StringBuilder
		 */
		StringBuilder sb = new StringBuilder();
		
		int ch = 0;
		
		while((ch=myRead())!=-1){
			
			if(ch=='\r'){
				continue;
			}
			if(ch=='\n'){
				return sb.toString();
			}			
			sb.append((char)ch);		
		}
		
		if(sb.length()!=0){
			return sb.toString();
		}
		
		return null;
	}
	
	/**
	 * 提供一个关闭资源的方法。
	 * @throws IOException 
	 */
	public void myClose() throws IOException{
		//其实就是关闭了流。
		r.close();
	}


	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		
		return 0;
	}


	@Override
	public void close() throws IOException {
	}
}
