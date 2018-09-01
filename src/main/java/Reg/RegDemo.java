package Reg;

public class RegDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 * 
		 * 正则表达式。
		 * 针对字符串进行操作的。
		 * 是由一些符号组成的字符串。代表的就是一些规则。
		 * 学习正则，其实就学些一些符号的使用。
		 * 
		 * 
		 */
		
		
		String QQ = "012345";
//		boolean b = checkQQ(QQ);
//		System.out.println("b="+b);
		
		//定义一个和需求一致的规则。如果当前字符串符合规则就是正确的。
		String reg = "[1-9][0-9]{4,14}";//第一个数为1到9，第二个数为0到9，可以有连续的4到14个
		boolean b = QQ.matches(reg);
//		System.out.println(QQ+":"+b);
		
		
		String temp = "booooooooooooooooook";
		String reg1 = "bo+k";
		boolean b1 = temp.matches(reg1);
		System.out.println(temp+":"+b1);
		

	}
	
	/*
	 * 对QQ号进行校验。
	 * 要求：5-15位，0不可以开头，必须都是数字。
	 */
	public static boolean checkQQ(String QQ){
		
		boolean temp = false;
		int len = QQ.length();
		if(len>=5 && len<=15){
			
			if(!QQ.startsWith("0")){
				try{
				long l = Long.parseLong(QQ);
				System.out.println("QQ号"+QQ+"是正确的。");
				temp = true;
				}catch(NumberFormatException e){
					System.out.println("QQ号中存在非法字符");
				}
				
			}else{
				System.out.println("不可以零开头。");
			}
			
		}else{
			System.out.println("长度错误");
			
		}
		
		return temp;
	}

}
