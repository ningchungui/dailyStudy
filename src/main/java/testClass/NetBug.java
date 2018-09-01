package testClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetBug {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		readMail();
	}

	public static void readMail() throws IOException {
		
		URL url = new URL("http://192.168.1.20:8080/index.jsp");
		
		URLConnection conn = url.openConnection();
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		BufferedReader bufr  = new BufferedReader(new FileReader("c:\\mail.htm"));
		
		String line = null;
		
		//定义规则。mail规则。
		String reg = "[a-zA-Z0-9_-]+@\\w+(\\.\\w+)+";
		Pattern p = Pattern.compile(reg);
		while((line=bufIn.readLine())!=null){
			
			
			Matcher m = p.matcher(line);
			while(m.find()){
				System.out.println(m.group());
			}
		}
		
		bufIn.close();
		
	}

}
