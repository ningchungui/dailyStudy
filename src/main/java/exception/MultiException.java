package exception;

/**
 * Create by NING on 2018/7/1 0001.<br>
 */
public class MultiException {
    public static void main(String[] args) {
        Teacher t = new Teacher("毕老师");
        try {
            t.prelect();
        } catch (NoPlanException e) {
            System.out.println("换人");
        }
    }
}

/*
需求：毕老师用电脑上课。

所产生的问题。
电脑出问题。
蓝屏，冒烟。


*/
//描述问题。
class LanPingException extends Exception {
    LanPingException(String msg) {
        super(msg);
    }
}

class MaoYanException extends Exception {
    MaoYanException(String msg) {
        super(msg);
    }
}

class NoPlanException extends Exception {
    NoPlanException(String msg) {
        super(msg);
    }
}

//
class Computer {
    int state = 1;

    void run() throws LanPingException, MaoYanException {
        if (state == 1)
            throw new LanPingException("蓝屏啦！");
        if (state == 2)
            throw new MaoYanException("冒烟了，废了！");
        System.out.println("电脑运行");
    }

    void reset() {
        System.out.println("电脑重启！");
        state = 0;
    }
}

//
class Teacher {
    private String name;
    private Computer cmpt;

    Teacher(String name) {
        this.name = name;
        cmpt = new Computer();
    }

    public void prelect() throws NoPlanException {
        try {
            cmpt.run();
            System.out.println("讲课");

        } catch (LanPingException e) {
            System.out.println(e.toString());
            cmpt.reset();
            prelect();
        } catch (MaoYanException e)//MaoYanException e = new MaoYanException("");
        {
            System.out.println(e.toString());
            test();
//			throw e;//将解决不了的问题继续抛出。
            throw new NoPlanException("课时进度无法继续");

        }
    }

    public void test() {
        System.out.println("做练习");
    }
}

/**
 * class
 * {
 * public static void main(String[] args)
 * {
 * System.out.println("Hello World!");
 * }
 * }
 * <p>
 * 异常：
 * <p>
 * Throwable
 * |--Error
 * |--Exception
 * |--RuntimeException
 * <p>
 * 1，它是什么？
 * 就是不正常，是java运行时发生的不正常情况。
 * 怎么来的？java按照面向对象思想将问题进行描述，封装成了对象。
 * 问题的基本信息有：名字，信息，位置。
 * 举例说明：
 * 角标越界。
 * <p>
 * 2，它有特点？
 * 1，问题有很多，分成两大派一种是可处理的Exception，一种是不需要处理的Error。
 * 这样就形成了体系。
 * 2，这个体系具备着独一无二的可抛性。可抛性：可以被throw throws关键字操作。当函数内容有throw
 * 抛出异常对象，并未进行try处理，必须要在函数上声明，都编译失败。注意，runtimeexception除外
 * 也就是说，函数内如果抛出的是RuntimeException异常，函数上可以不用声明。
 * 3，异常中还分了编译器检测异常，运行时异常。区别是：编译时被检测的异常需要定义针对性的处理方式。
 * 运行时异常，通常功能内部抛出，可以不需要在功能上声明，建议不处理，让程序停止。
 * <p>
 * <p>
 * 3，它怎么用？
 * 1，java提供了很多对已有问题的异常对象。
 * 同时也可以自定义异常对象，只要继承Exception 或者RuntimeException就哦了。
 * 里面就简单的写法就是只定义构造函数，父类有几个，子类写几个，
 * 子类的构造函数就一句super调用父类中对应的构造函数即可。
 * class  MyException extends Exception
 * {
 * MyException()
 * {
 * super();
 * }
 * MyException(String message)
 * {
 * super(message);
 * }
 * }
 * <p>
 * 2，功能中满足某一个特定条件，出现了问题，可以用throw 将问题对象抛出。
 * 并用throws在功能上声明，声明的目的是让调用者进行预先处理。
 * <p>
 * <p>
 * 3，对于异常处理，可以使用try catch finally完成。
 * 记住：catch才是真正的处理部分。
 * <p>
 * 练习：除法运算，除数不可以为负数。
 * 第二，获取长方形面积。长宽不可以为0和负数。
 * <p>
 * class Rec
 * {
 * private int length;
 * private int width;
 * Rec(int length,int width)
 * {
 * this.length = length;
 * this.width = width;
 * }
 * public int getArea()
 * {
 * return length*width;
 * }
 * }
 * <p>
 * 4，它什么时候用？
 * 1，当功能调用因为参数非法导致功能无法运行，这时要用异常体现。
 * <p>
 * public int div(int a,int b)//a=1,b=-1
 * {
 * if(b==0)
 * throw new ArithmeticException("被零除了");//  / by zero;
 * return a/b;
 * }
 * 提高了程序的健壮性，将功能流程代码很问题处理代码进行了分离。
 * <p>
 * <p>
 * try
 * {
 * <p>
 * }
 * catch ()
 * {
 * }
 * 处理异常，但不需要对资源进行释放。
 * final只有一种情况不会执行。当执行到System.exit(0);
 * <p>
 * try
 * {
 * <p>
 * }
 * finally
 * {
 * //将关闭资源的代码存放在finally中。
 * }
 * 不处理异常，但是需要进行资源释放。
 * <p>
 * <p>
 * function()
 * {
 * try
 * {
 * 连接数据库。
 * <p>
 * 操作数据库。throw new Exception();
 * <p>
 * }
 * finally
 * {
 * 关闭数据库。
 * <p>
 * }
 * <p>
 * }
 * <p>
 * 自定义异常：
 * 定义类继承Exception或者RuntimeException
 * 1，为了让该自定义类具备可抛性
 * 2，让改该类具备操作异常的共性方法
 * <p>
 * 当要定义自定义异常的信息时，可以使用父类已经定义好的功能
 * 异常信息传递给父类的构造函数
 * class myException extends Exception
 * {
 * MyException(String message)
 * {
 * super(message);
 * }
 * }
 * <p>
 * 自定义异常：按照Java面向对象的思想，将程序中出现的特有问题进行封装
 * <p>
 * 异常的好处：
 * 1，讲问题进行封装
 * 2，将正常流程代码和问题处理代码相分离，方便与阅读
 * <p>
 * <p>
 * 异常的处理原则：
 * 1,处理方式有两种:try或者throws
 * 2，调用到抛出异常的功能是，抛出几个，就处理几个。
 * 一个try对应多个catch
 * 3，多个catch，父类的catch放到最下面
 * 4，catch内，需要定义针对性的处理方式，不要简单的定义printStackTrace，输出语句。
 * 也不要不写。
 * 当捕获到的异常本功能处理不了时，可以继续在catch中抛出
 * try
 * {
 * throw new AException();
 * }
 * catch (AException e)
 * {
 * throw e;
 * }
 * 如果该功能处理不了，但不属于该功能出现的异常。
 * 可以将异常转换后，在抛出和该功能相关的异常。
 * <p>
 * 或者异常可以处理，当需要将异常产生的和本功能相关的问题提供出去，
 * 当调用者知道，并处理，也可以将捕获异常处理后，转换新的异常
 * try
 * {
 * throw new AException();
 * }
 * catch (AException e)
 * {
 * throw new BException();
 * }
 * 比如，汇款的例子
 * <p>
 * 异常的注意事项：
 * 在子父类覆盖时：
 * 1，子类抛出的异常必须是父类的异常的子类或者子集
 * 2，如果父类或者接口没有异常抛出是，子类覆盖出现异常，只能try不能抛
 */

