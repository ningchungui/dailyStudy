package File;

import java.io.File;
import java.io.FileFilter;

import cn.itcast.io.p2.filter.FilterByHidden;

public class FileDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		演示文件过滤器。
		fileMethodDemo();
	}
	
	public static void fileMethodDemo(){
		
		File dir = new File("E:\\JAVASE0228_SH\\day05");
		
		
		//创建一个文件过滤器用于过滤隐藏文件。
		FileFilter filter = new FilterByHidden();
		File[] files = dir.listFiles(filter);
		
		for(File file : files){
			System.out.println(file.getName());
		}
		
		
	}

}
