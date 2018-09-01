package Reg;

import java.util.Arrays;

public class RegTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		test1();
		test3();
	}
	
	
	
	
	/*
	 * 我我....我....我我..我我..我..要要..要要..要要..要要学..学学学..学学..学编编..编编编.编程程.....程...程程...程程..程程
	 * 把它还原成  我要学编程。
	 *
	 *到底用四种功能的哪一种呢，或者是那几个呢？
	 *思路方式：
	 *1，如果只想知道该字符是否正确，使用匹配
	 2，想要将已有的字符串变换成另一个字符串，替换
	 3，按照自己定义的方式将字符串编程多个字符串，切割，获取规则以外的字串
	 4，想要拿到符合需求的字符串子串，获取，获取符合规则的子串
	 *
	 *
	 */
	public static void test1(){
		
		String str = "我我....我....我我..我我..我..要要..要要..要要..要要学..学学学..学学..学编编..编编编.编程程.....程...程程...程程..程程";
		
		/*
		 * 使用正则的替换功能。
		 * 1,将 . 去掉。
		 * 2,将叠词变成一个。
		 */
		
		str = str.replaceAll("\\.+", "");
		System.out.println(str);
		str = str.replaceAll("(.)\\1+", "$1");
		System.out.println(str);
	}
	
	
	/*
	 * 10.10.10.10  192.168.1.200 3.3.3.3 127.0.0.108
	 * 对ip地址排序。

	 还按照字符串的自然顺序排序，只要让他们每一段都是3位即可
	 1，按照每一段需要的最多的0进行补齐，那么每一段就会至少保证有3位
	 2，将每一段只保留3位，这样所有的IP地址都是每一段3位
	 */
	public static void test2(){
		
		
		String ip = "10.10.10.10  192.168.1.200   3.3.3.3 127.0.0.108";
		
		/*
		 * 为了排序方便，每一段都补两个零。保证每一段至少三位。
		 * 替换就可以了。
		 */
		
		ip = ip.replaceAll("(\\d+)", "00$1");
		System.out.println(ip);
		
		//将每一段都保留最后三位。
		ip = ip.replaceAll("0*(\\d{3})", "$1");//$1指第一组
		System.out.println(ip);
		
		String[] ips = ip.split(" +");
		Arrays.sort(ips);
		for(String x : ips){
			System.out.println(x.replaceAll("0*(\\d+)", "$1"));
		}
		
		
	}
	
	/*
	 * 对邮件地址进行校验。
	 */
	public static void test3(){
		
		String mail = "abc123@sina.com.cn";
		
		String reg = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,}){1,3}";//封装组重用，(\\.[a-zA-Z]{2,})这就是一个组
		reg = "\\w+@\\w+(\\.\\w+)+";//1@1.1
		
//		mail.indexOf("@")!=-1
		boolean b = mail.matches(reg);
		System.out.println(mail+":"+b);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
