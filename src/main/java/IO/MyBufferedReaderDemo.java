package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyBufferedReaderDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
		FileReader fr = new FileReader("temp\\buf.txt");
		
		MyBufferedReader myBufr = new MyBufferedReader(fr);
		
		String line = null;
		while((line=myBufr.myReadLine())!=null){
			System.out.println(line);
		}
		
		myBufr.myClose();
		
		
	}

}
