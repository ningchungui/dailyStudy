package Frame;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class LianTongDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
		String str = "��ͨ";
		
		byte[] arr = str.getBytes("GBK");
		
		for(byte b : arr){
			System.out.println(Integer.toBinaryString(b&0xff));
		}
	}

}
