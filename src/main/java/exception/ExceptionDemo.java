package exception;

/**
 * Create by NING on 2018/7/1 0001.<br>
 */
public class ExceptionDemo {
    public static void main(String[] args) //
    {
        Demo d = new Demo();
        try {
            int num = d.div(4, 0);
            System.out.println("num=" + num);
        } catch (Exception e)//调用的工作抛出的是什么异常，就catch什么异常。Exception e = new ArithmeticException();
        {
            System.out.println("异常啦！！！");
            System.out.println("message:" + e.getMessage());//获取异常信息。
            System.out.println("toString:" + e.toString());//获取异常名称和异常信息。

            e.printStackTrace();//打印，异常名称信息，位置到控制台上。就是默认的处理方式。
        }
        System.out.println("over");
    }


}

class Demo {
    int div(int a, int b) throws Exception//在函数行声明问题。
    {
        if (b == 0)
            throw new Exception("我是信息，除数为零啦！！！废啦！");//创建一个异常对象。 并将其用throw抛出。
        return a / b;
    }
}
