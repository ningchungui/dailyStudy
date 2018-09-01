package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderDemo {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * 演示LineNumberReader。
		 */
		FileReader fr = new FileReader("temp\\CopytTextTest.java");
		LineNumberReader lnr = new LineNumberReader(fr);
		
		String line =  null;
		lnr.setLineNumber(100);
		while((line=lnr.readLine())!=null){
			
			System.out.println(lnr.getLineNumber()+":"+line);
		}
		lnr.close();
		
	}

}
