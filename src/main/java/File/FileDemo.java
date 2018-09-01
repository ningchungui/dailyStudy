package File;

import java.io.File;
import java.io.FilenameFilter;

import cn.itcast.io.p2.filter.FilterByContains;
import cn.itcast.io.p2.filter.FilterBySuffix;

public class FileDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		/*
		 * 演示File类中的list方法。
		 */
		
		fileMethodDemo2();
	}
	
	/*
	 * 获取指定目录下的扩展名为.java文件。
	 */
	public static void fileMethodDemo2(){
		
		File dir = new File("E:\\JAVASE0228_SH\\day05");
		//创建一个用于过滤.java文件的过滤器。
//		FilenameFilter filter = new FilterByJava();
		
		
		//创建一个用于过滤后缀名的过滤器。
//		FilenameFilter filter = new FilterBySuffix(".bmp");
		//创建一个用于过滤包含指定名称的过滤器。
		FilenameFilter filter = new FilterByContains("Demo");
		String[] names = dir.list(filter);
		
		System.out.println(names.length);
		for(String name : names){
			System.out.println(name);
		}
		
	}
	
	
	
	public static void fileMethodDemo(){
		
		File file = new File("E:\\JAVASE0228_SH\\day05");
//		if(file.exists() && file.isDirectory())//对一个目录使用list前建议先判断。
		//list():列出当前目录下的文件以及文件夹的名称。
		String[] names = file.list();
//		System.out.println(names.length);
		
		for(String name : names){
			if(name.endsWith(".txt"))
			System.out.println(name);
		}
		
		
	}

}
