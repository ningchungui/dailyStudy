package Properties;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		/*
		 * Properties : Map中Hashtable的子类。
		 * 特点：
		 * 1，是一个双列集合。map中的方法都是可以用。
		 * 2，持久的属性集，数据的生命周期较长。
		 * 3，Properties 可保存在流中或从流中加载
		 * 4，键值都是字符串类型。
		 */
		
//		methodDemo();
		
//		methodDemo3();
		
		myLoad();
	}
	
//	模拟laod方法。
	/*
	 * 思路：
	 * 其实就是对规则文件进行一行的读取，对一行字符串数据进行=切割。
	 * 左边作为键，右边作为值。哦了。
	 */
	public static void myLoad() throws IOException{
		
		Properties prop = new Properties();
		
		BufferedReader bufr = new BufferedReader(new FileReader("temp\\prop.txt"));
		
		String line = null;
		while((line=bufr.readLine())!=null){
			
			if(line.startsWith("#"))
				continue;
			String[] arr = line.split("=");
			prop.setProperty(arr[0], arr[1]);
		}
		
		prop.list(System.out);
		
		bufr.close();
	}
	
	
	/*
	 * 从流中加载数据信息。
	 */
	public static void methodDemo3() throws IOException {
		
		Properties prop = new Properties();
		
		//创建读取流对象。和指定规则的数据文件关联。
		FileInputStream fis = new FileInputStream("temp\\prop.txt");
		
		//通过properties的load方法将流关联的数据加载进集合。
		prop.load(fis);
		
		prop.list(System.out);
		
	}


	/*
	 * 演示和流相关的方法。
	 */
	public static void methodDemo2() throws IOException{
		
		Properties prop = new Properties();
		
		prop.setProperty("zhangsan", "30");
		prop.setProperty("wangwu", "36");
		prop.setProperty("lisi", "25");
		
//		prop.list(System.out);
		
		FileOutputStream fos = new FileOutputStream("temp\\prop.txt");
		prop.store(fos,"oh no");
		
		fos.close();
	}
	
	
	
	/*
	 * 演示Properties集合的基本存取的功能。
	 */
	
	public static void methodDemo(){
		
		// 1,创建集合。Properties
		Properties prop = new Properties();
		
		//2，添加键值对。
		prop.setProperty("zhangsan", "30");
		prop.setProperty("wangwu", "36");
		prop.setProperty("lisi", "25");
		
		//3，通过方法获取set集合。
		Set<String> keySet = prop.stringPropertyNames();
		
		for(String key : keySet){
			String val = prop.getProperty(key);
			System.out.println(key+":"+val);
		}
		
	}

	
	
	
}
