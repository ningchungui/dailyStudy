package File;

import java.io.File;
import java.io.FilenameFilter;

public class FilterByContains implements FilenameFilter {

	
	private String contant;
	
	public FilterByContains(String contant) {
		super();
		this.contant = contant;
	}

	@Override
	public boolean accept(File dir, String name) {

		return name.contains(contant);
	}

}
