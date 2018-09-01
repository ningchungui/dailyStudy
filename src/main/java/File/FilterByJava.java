package File;

import java.io.File;
import java.io.FilenameFilter;

public class FilterByJava implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {

		/*
		 * 获取名称是.java扩展名的。
		 */
		
//		System.out.println(dir+"----"+name);
		return name.endsWith(".java");
	}

}
