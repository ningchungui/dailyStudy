package IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * 演示BufferedWriter.
		 * 缓冲区是对流中的数据进行缓冲的。所以必须要在构造缓冲区时，明确具体的流对象。 
		 */
		//1,创建字符输出流对象；
		FileWriter fw = new FileWriter("temp\\buf.txt");
		
		//2,创建缓冲区对象，将流对象传给缓冲区的构造函数。
		BufferedWriter bufw = new BufferedWriter(fw);
		
		for(int x=1; x<=4; x++){
			
			bufw.write(x+"-hehe");
			bufw.newLine();//跨平台的换行符，可在Unix和Linux、Windows上用
			bufw.flush();
		}
		bufw.close();//不用在对fw进行关闭，因为关闭缓冲区的就是在关闭该流。
	}
}
