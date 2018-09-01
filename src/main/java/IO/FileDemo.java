package IO;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class FileDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * File类：
		 * 用于描述文件或者文件夹的对象。
		 * 一定提供了操作文件或者文件夹的方法。
		 * 
		 * 
		 * 
		 */
//		fileConsDemo();
		fileMethodDemo2();
	}
	
	/*
	 * 演示获取
	 */
	public static void fileMethodDemo2() {
		
		File file = new File("temp\\test2.txt");
		
		System.out.println("getAbsolutePath:"+file.getAbsolutePath());//
		System.out.println("getPath:"+file.getPath());
		System.out.println("getParent:"+file.getParent());
		System.out.println("getName:"+file.getName());
		System.out.println("getFreeSpace:"+file.getFreeSpace());//11718565888
		System.out.println("lastModified:"+file.lastModified());//1364456112843
		
		long time = file.lastModified();
		Date date = new Date(time);
		String str_time = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(date);
		System.out.println(str_time);
		System.out.println("length:"+file.length());
		
		
		File[] files = File.listRoots();
		for(File f : files){
			System.out.println(f.getFreeSpace());
		}
		
		
	}

	/*
	 * 演示File类的方法。
	 */
	
	public static void fileMethodDemo() throws IOException{
		
		File f = new File("temp\\file");
		
//		f = new File("temp\\a");
		
		//1，判断其存在。
//		boolean b = f.exists();
//		System.out.println(b);
		
		//创建。如果该文件不存在，则创建，如果存在，则不创建。
//		boolean b = f.createNewFile();
//		System.out.println(b);
		
		//创建文件夹。
//		f.mkdir();
//		f.mkdirs();//创建多级目录。
		
		//删除。 
//		boolean b = f.delete();
//		System.out.println(b);
		
		//判断是否是文件夹或者文件
		System.out.println("isDirectory:"+f.isDirectory());
		System.out.println("isFile:"+f.isFile());
		
		
		
	}
	
	
	/*
	 * 演示File类的构造器。
	 */
	public static void fileConsDemo(){
		//可以将已存在或者未存在的内容封装成文件对象。
//		File f1 = new File("temp"+System.getProperty("file.separator")+"abc.txt");
		File f1 = new File("temp"+File.separator+"abc.txt");
		
		File f2 = new File("temp\\","aaa.txt");
		
		File f = new File("temp\\");
		File f3 = new File(f,"abc.txt");
		
	}

}
