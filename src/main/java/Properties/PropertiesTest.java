package Properties;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * 对已有的prop.txt文件中的王五的年龄进行更改为26。
		 * 思路：
		 * 1，既然这个文件中的数据是有特定键值对格式的。
		 * 所以可以通过读取该数据存储到集合中。
		 * 2，将集合中的数据进行修改。
		 * 3，将集合中的数据进行持久化存储。就哦了。
		 * 
		 */
		
		File file = new File("temp\\prop.txt");
		//1,创建一个Properties集合。
		Properties prop = new Properties();
		
		//2,创建一个输入流对象和指定的文件关联。
		FileReader fr = new FileReader(file);
		
		//3,将流关联的数据加载到Properties中。
		prop.load(fr);
		
		//4,对集合中的名称为wangwu的值进行修改。
		prop.setProperty("wangwu", "26");
			
		//5,创建一个输出流对象。
		FileWriter fw = new FileWriter(file);
		
		//6,将集合的键值持久化存储到指定文件中。
		prop.store(fw, "");
		
		
		//7,关闭资源。
		fw.close();
		fr.close();
		
		
	}
	

}
