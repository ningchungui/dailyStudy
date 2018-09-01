package File;

import java.io.File;
import java.io.FileFilter;

public class FileFilterByContains implements FileFilter {

	private String str;
	
	public FileFilterByContains(String str) {
		super();
		this.str = str;
	}

	@Override
	public boolean accept(File pathname) {

		return pathname.getName().contains(str);
	}

}
