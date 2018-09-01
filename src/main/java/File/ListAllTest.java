package File;

import java.io.File;

public class ListAllTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 * 课上练习一：列出指定目录中的内容包含着子目录中的内容。
		 */
		
		File dir = new File("E:\\JAVASE0228_SH\\day13e");
		listAll(dir,0);
		
	}
	/**
	 * 对指定目录进行列出，包含子目录。
	 * @param dir
	 */
	public static void listAll(File dir,int level){
	
		System.out.println(getLevel(level)+dir.getName());
		File[] files = dir.listFiles();
		
		level++;
		
		for(File file : files){
			if(file.isDirectory()){
				listAll(file,level);
			}
			else
				System.out.println(getLevel(level)+file.getName());
		}
	}
	private static String getLevel(int level) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("|--");
		for(int x=0; x<level; x++){
			sb.insert(0,"  ");
		}
		return sb.toString();
	}

}
