package File;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetJavaListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * 练习：将指定目录中的所有java文件(包含子目录)的绝对路径写入到指定文件中。形成java文件清单列表。 思路：
		 * 1，对指定的目录进行遍历，包含子目录的遍历。 2，在遍历中加入过滤器。 3，将满足过滤器的文件进行临时存储。
		 * 4，将存储的数据的指定的信息比如 绝对路径写入到指定文件中。
		 */

		File dir = new File("E:\\JAVASE0228_AVI_SH");

		// 创建一个文件过滤器，用于过滤指定后缀名的文件。
		FileFilter filter = new FileFilterBySuffix(".avi");

		// 创建一个集合，用于存储符合过滤条件的文件。
		List<File> list = new ArrayList<File>();

		// 定义一个功能。用于对指定的目录进行遍历，并传入指定的过滤器和临时容器。将满足条件的file存储到容器中。
		listAllFiles(dir, filter, list);

		// System.out.println(list.size());

		// 1，创建一个存储java文件路径的文件。
		File file = new File(dir, "avilist.txt");

		writeToFile(list, file);

	}

	/**
	 * 将list中存储的file对象的指定的信息写入到文件中。
	 * 
	 * @param list
	 * @param file
	 */
	public static void writeToFile(List<File> list, File file) {

		// 1,既然要文本数据写入到一个文件中。就需要使用io技术。
		// 目的，是文本，Writer，操作文件，硬盘。FileWriter，高效。BufferedWriter
		BufferedWriter bufw = null;
		try {
			bufw = new BufferedWriter(new FileWriter(file));
			// 对list集合进行遍历。
			for (File f : list) {

				bufw.write(f.getAbsolutePath());
				bufw.newLine();
				bufw.flush();

			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (bufw != null)
				try {
					bufw.close();
				} catch (IOException e) {

					throw new RuntimeException("关闭失败");
				}
		}

	}

	/**
	 * 在遍历之后，将满足条件的file存储到了临时容器中。
	 * 
	 * @param dir
	 * @param filter
	 * @param list
	 */
	public static void listAllFiles(File dir, FileFilter filter, List<File> list) {

		// 1,对指定的目的进行遍历。
		File[] files = dir.listFiles();

		for (File file : files) {

			if (file.isDirectory()) {// 如果是目录，进行递归。
				listAllFiles(file, filter, list);
			} else {
				if (filter.accept(file)) {// 如果是文件，就将文件传递给过滤器。进行过滤。
					// 过滤器方法返回true，那么对满足过滤条件的文件进行存储。
					list.add(file);
				}
			}

		}

	}

}
