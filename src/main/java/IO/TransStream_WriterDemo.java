package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TransStream_WriterDemo {

	/**
	 * @param args
	 * @throws IOException 
		
		
		------------------------------------------------
		流操作的规律：
		最痛苦的是流对象有很多，不知道该用哪一个

		通过两个明确来完成

		1.明确源和目的
		源：输入流。InputStream Reader
		目的：输出流。OutputStream Writer
		2.操作的数据是否是纯文本
		是：字符流
		不是：字节流
		3.当体系明确后，在确定要使用那个具体的对象
		通过设备来进行区分
		源设备：内存，硬盘，键盘
		目的设备：内存，硬盘，控制台


1，将一个文本文件中的数据存储到另外一个文件中，复制文件
	源：因为是源，所以使用读取流。InputStream Reader
	是不是操作文本文件
	是！这时就可以选择Reader
	这样体系就明确了

	接下来明确要使用该体系中的那个对象
	明确设备：硬盘上一个文件
	Reader体系中可以操作文件的对象是FileReader

	是否要提高效率：是!.加入Reader体系中缓冲区BufferedReader

	FileReader fr = new FileReader（“a.txt”）
	BufferedReader bufr=new BufferedReader(fr)


	目的：OutputStream Writer
	是否是纯文本
	是Writer
	设备：硬盘，一个文件
	Writer体系中可以操作文件的对象是FileWriter
	是否要提高效率：是！加入Writer体系中缓冲区BufferedWriter
	FileWriter fr = new FileWriter（“a.txt”）
	BufferedWriter bufr=new BufferedWriter(fr)
		---------------------------------------------------------
练习：将一个图片文件中的数据存储到另外一个文件中。复制文件。要按照以上格式自己完成三个明确

需求:将键盘录入的数据保存到一个文件中
这个需求中有源和目的都存在
源：InputStream Reader
是不是纯文本了？是！Reader

设备：键盘。对应的对象是System.in
不是选择Reader吗？System.in对应的不是字节流吗？
为了操作键盘的文本数据方便。转成字符流按照字符串操作是最方便的
所以既然明确了Reader，那么就将System.in转换成Reader
用Reader体系中的转换流InputStreamReader（System.in）


InputStreamReader isr = new InputStreamReader(System.in)

需要转换吗，需要就BufferedReader
BufferedReader bufr = new BufferedReader(isr)

目的：OutputStream writer
是否是文本？是 Writer
设备：硬盘。一个文件。使用FileWriter

FileWriter fr = new FileWriter("d.txt");



	 */
	public static void main(String[] args) throws IOException {

		
		/*
		 * 演示转换流。
		 */
		
//		writeFile();
	}
	
	/*
	 * 第一个，先将已有的中文字符串，按照编码存储到硬盘上。
	 */
	
	public static void writeFile() throws IOException{
		
		//使用默认 编码表。
//		FileWriter fw = new FileWriter("temp\\default.txt");
//		fw.write("你好");
//		fw.close();
		
		
		//使用转换流，通过默认编码表。将字符转换成字节 转换流。OutputStreamWriter
//		FileOutputStream fos = new FileOutputStream("temp\\trans_default.txt");
//		OutputStreamWriter osw = new OutputStreamWriter(fos);		
//		osw.write("你好");		
//		osw.close();
		
		//使用指定编码表GBK。
//		FileOutputStream fos = new FileOutputStream("temp\\trans_GBK.txt");
//		OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");		
//		osw.write("你好");		
//		osw.close();
		/*
		转换流：字节流+编码表(可以指定)。
			|--用于操作File的子类：字节流+本地默认码表(固定)。对默认编码的字符文件操作起来比父类更为便捷。
		*/
		
		//使用指定编码表GBK。
		FileOutputStream fos = new FileOutputStream("temp\\trans_U8.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");		
		osw.write("你好");		
		osw.close();
	}

}
