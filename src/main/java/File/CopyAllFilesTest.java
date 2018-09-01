package File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.io.p2.filter.FileFilterByContains;

public class CopyAllFilesTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * 编程题：将day01-day21所有的作业文件复制到同一个名称为"Java基础一期作业"文件夹下。
		 * 
		 * 思路：
		 * 1，对day01-day21的父目录进行遍历。
		 * 2，在遍历时加入过滤器，过滤包含 作业 字符串的文件,将其进行存储。
		 * 3，对容器中的文件对象进行复制。
		 * 
		 */
		
		
		
		//1，明确具体的目录。
		File dir = new File("E:"+File.separator+"JAVASE0228_SH");
		
		//2，创建过滤器。
		FileFilter filter = new FileFilterByContains("作业");
		
		//3，创建一个容器。
		List<File> list = new ArrayList<File>();
		
		//要对目录进行遍历。
		listAllFiles(dir,filter,list);
		
		
//		System.out.println(list.size());
		
		File destDir = new File("E:"+File.separator+"JAVASE0228_SH"+File.separator+"上海一期Java基础作业");
		//将list集合中的file对象复制到指定目录下。
		copyFileToDir(list,destDir);
		
	}

	private static void copyFileToDir(List<File> list, File destDir) throws IOException {
		
		/*
		 * 思路：
		 * 1，对集合进行遍历。
		 * 2，对遍历到的file进行输入流的关联。
		 * 3，将读到的数据写入到目的文件夹的文件中。
		 */
		
		for(File file : list){
			
			BufferedReader bufr = new BufferedReader(new FileReader(file));			
			BufferedWriter bufw = new BufferedWriter(new FileWriter(new File(destDir,file.getName())));
//			PrintWriter out = new PrintWriter(new FileWriter(new File(destDir,file.getName())),true);
			
			String line = null;
			
			while((line=bufr.readLine())!=null){
				
				bufw.write(line);
				bufw.newLine();
				bufw.flush();
			}
			
			bufw.close();
			bufr.close();
			
		}
		
		
		
		
		
	}

	public static void listAllFiles(File dir, FileFilter filter,
			List<File> list) {
		
		//1，对指定的目录进行当前文件的获取。
		File[] files = dir.listFiles();
	
		//2,对其进行遍历。
		for(File file : files){
			
			if(file.isDirectory()){
				listAllFiles(file,filter,list);
			}else{
				if(filter.accept(file)){//只要满足过滤条件，就将其添加到集合中。
					list.add(file);
				}
			}
			
		}
	}
	
	

}
