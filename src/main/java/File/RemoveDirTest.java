package File;

import java.io.File;

public class RemoveDirTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		File dir = new File("E:\\demodir");
		
		removeDir(dir);
	}
	/**
	 * 删除一个带内容的目录。
	 * windows中的删除，是从里往外删除。
	 * 所以删除时必须要将最里面的文件夹中的内容先删除，才可以将该文件夹删除，然后依次向外删。
	 * 需要对文件夹进行包含子目录的遍历。
	 */
	public static void removeDir(File dir){
		
		//对dir进行当前目录中文件和文件夹对象的获取。
		File[] files = dir.listFiles();
		
		for(File file : files){
			if(file.isDirectory()){
				removeDir(file);
			}
			else{
				System.out.println(file+"--"+file.delete());
			}
		}
		System.out.println(dir+"--"+dir.delete());
		
	}
	
}
