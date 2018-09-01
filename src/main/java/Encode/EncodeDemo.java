package Encode;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {

		
		/*
		 * 字符串--->字节数组：编码。
		 * 字节数组--->字符串：解码
		 * 你好：
		 * GBK:-60 -29 -70 -61 
		 * UTF-8：-28 -67 -96 -27 -91 -67 
		 * 
		 * 原则：
		 * 编码编错了，就不用解码了。
		 * 编对了，解错了，有可能还有救！
		 */
		/*
		String str = "你好";
		
//		编码：
		byte[] arr = str.getBytes("GBK");		
		printByte(arr);
		
		
//		解码：
		String s1 = new String(arr,"ISO8859-1");
		System.out.println("s1="+s1);
		
		
		byte[] arr1 = s1.getBytes("ISO8859-1");
		printByte(arr1);
		
		String s2 = new String(arr1,"GBK");
		System.out.println("s2="+s2);*/
		
		
		//不太好救！
		String str = "谢谢";
//		编码：
		byte[] arr = str.getBytes("GBK");		
		printByte(arr);
		
		
//		解码：
		String s1 = new String(arr,"UTF-8");
		System.out.println("s1="+s1);
		
		
		byte[] arr1 = s1.getBytes("UTF-8");
		printByte(arr1);//-17 -65 -67 -17 -65 -67 -17 -65 -67 
		
		String s2 = new String(arr1,"GBK");
		System.out.println("s2="+s2);
		
		
	}

	public static void printByte(byte[] arr) {
		for(byte b : arr){
			
			System.out.print(b+" ");
		}
		System.out.println();
		
	}

}
