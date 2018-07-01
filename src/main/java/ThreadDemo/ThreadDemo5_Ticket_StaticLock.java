package ThreadDemo;

/*
静态同步函数使用的锁是什么？
就是所在类的类名.class  字节码文件对象。
静态进内存时，内存中没有本类对象，但是一定有该类对应的字节码文件对象
类名.class   该对象的类型是class



*/
class Ticket1 implements Runnable
{
	private static  int num = 100;
	boolean flag = true;
	Object obj = new Object();
	public void run()
	{
		if(flag)
		{
			while(true)
			{
				synchronized(Ticket1.class)//super.getClass()
				{
					if(num>0)
					{
						try{Thread.sleep(10);}catch(InterruptedException e){}
						System.out.println(Thread.currentThread().getName()+"..obj:"+num--);
					}
				}
			}
		}
		else
			while(true)
			{			
				this.sale();
			}
	}

	public static synchronized/**/ void sale()//static同步函数。
	{
		if(num>0)
		{
			try{Thread.sleep(10);}catch(InterruptedException e){}
			System.out.println(Thread.currentThread().getName()+"..func:"+num--);
		}
	}
}

class ThreadDemo5_Ticket_StaticLock
{
	public static void main(String[] args) 
	{
		Ticket1 t = new Ticket1();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
//		Thread t3 = new Thread(t);
//		Thread t4 = new Thread(t);
		t1.start();
		try{Thread.sleep(10);}catch(InterruptedException e){}
		t.flag = false;
		t2.start();
//		t3.start();
//		t4.start();
	}
}


