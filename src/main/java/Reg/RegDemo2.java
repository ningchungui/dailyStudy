package Reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		 * 正则对字符串操作的功能：
		 * 1,匹配。
		 * 		使用的就是字符串对象的方法。matches(String regex) 
		 * 
		 * 2,切割。
		 * 		使用的是String中的split方法。
		 * 
		 * 3,替换。
		 * 		使用的还是String中的replaceAll方法。
		 * 
		 * 
		 * 4,获取。
		 * 		既然字符串中没有直接提供该功能。
		 * 		只能去找正则表达式对象。	
		 * 	Pattern p = Pattern.compile("a*b");
 			Matcher m = p.matcher("aaaaab");
 			boolean b = m.matches();
		 * 
		 */
//		checkPhone();
//		splitDemo();
//		replaceAllDemo();
//		getString();

		//splitDemo("c:\\abc\\a.txt","\\\\");//按照\\切割
        //splitDemo("afffhqjophoooofaakjk","(.)\\1+");//按照叠词切割

		//String str1 = "jfakjoiiooioijnlklllljfhhjhhh";
		//replaceAllDemo(str1,"(.)\\1","$1");//将重叠字符替换成单个字符
	}
	
	public static void getString(){

		//将符合规则的字符串取出
		
		String str = "da jia zhu yi la ,ming tian fang jia la!";
		System.out.println(str);
		//1，定义规则。
		String reg = "\\b[a-z]{3}\\b";//\b是单词的边界
		//2,将规则封装成正则对象。
		Pattern p = Pattern.compile(reg);
		
		//3,通过正则对象获取匹配器对象，并和被操作的字符串相关联。
		Matcher m = p.matcher(str);
		
		//4, 通过匹配器对象的方法对字符串进行规则的匹配。
//		boolean b = m.find();//将规则作用到字符上，并进行符合规则的字串查找
//		System.out.println(b);
//		System.out.println(m.group());//group用于匹配后的结果
		while(m.find()){
			System.out.println(m.start()+"..."+m.group()+"...."+m.end());
			
		}
		
	}
	
	
	public static void replaceAllDemo(){
		
		String str = "wer####tyuio***fgh";
		str = str.replaceAll("(.)\\1+", "$1");//按照叠词切割
		
		
//		str = "asdfghj345678905678kl;ertyuio";
//		str = str.replaceAll("\\d{5,}", "***");//只要连续的数字超过5个就将qui替换掉
		
		str = "15812345678";
		str = str.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
		System.out.println(str);
		
		
	}
	
	public static void splitDemo(){
		
		String str = "zhangsan.lisi.wangwu";
		String reg = "\\.";
		
		str = "wer####tyuio***fgh";
		reg = "(.)\\1+";
		
		String[] arr = str.split(reg);
		for(String s : arr){
			System.out.println(s);
		}
		
	}
	
	
	
	/*
	 * 对手机号码进行校验。
	 */
	public static void checkPhone(){
		
		String tel = "18600001111";
		String reg = "1[358]\\d{9}";  
		
		boolean b = tel.matches(reg);
		System.out.println(tel+":"+b);
		
		
	}

}
