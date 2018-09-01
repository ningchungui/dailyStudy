package Properties;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * 练习：记录一个程序运行的次数。如果次数达到5次，给出提示：试用次数已到，请注册。
		 * 思路：
		 * 1，需要计数器。定义在哪里呢？
		 * 2，因为程序关闭后，所有占用的内容都释放了。计数器数据也消失了。
		 * 3，如果想保持计数器的存在，必须将其进行持久化。
		 * 4，每次程序启动都需要先读取这个计数器数据，将其自增后，在存回计数器文件中。
		 * 
		 * 计数器需要通过名称和值来体现。这样阅读才有意义。所以要使用存储键值的集合。
		 * 而且要读取持久化的数据，所以可以选择Properties集合。
		 */
		
		if(isRun()){
			System.out.println("程序运行");
		}else{
			System.out.println("程序提前结束");
		}
		
	}

	private static boolean isRun() throws IOException {
		
		
		//1,创建一个Properties集合。
		Properties prop = new Properties();
		
		//2,通过输入流和配置文件关联。配置文件中记录的就是计数器信息。
		File confile = new File("temp\\count.properties");
		if(!confile.exists())//对该文件进行判断，如果不存在，则创建。
			confile.createNewFile();
		FileReader fr = new FileReader(confile);
		
		//3,将流关联的数据加载到集合中
		prop.load(fr);
		
		//加载后，说明集合中也许已有信息。
		//4，通过指定的键获取对应的次数。
		
		String value = prop.getProperty("time");
		int count = 0;
		
		if(value!=null){
			count = Integer.parseInt(value);
			if(count>=5){
				System.out.println("试用次数已到，请注册，给钱！");
				return false;
			}
		}
		count++;
		
		//5，将具体的键值存储到集合中。
		prop.setProperty("time", Integer.toString(count));
		
		
		//6，创建一个输出流。
		FileWriter fw = new FileWriter(confile);
		
		//7，将集合中的数据存储到指定文件中。
		prop.store(fw, "");
		
		//8,关闭资源。
		fw.close();
		fr.close();
			
		
		return true;
	}
	
	

}
