package ThreadDemo;

import java.util.concurrent.locks.*;


class Resource
{
	//定义一个商品都有名字。
	private String name;
	//定义一个商品的编号。
	private int count = 1;

	//定义用来判断是否有商品的标记。
	private boolean flag = false;
	

	//根据jdk1.5 版本的特性，创建一个锁对象。比同步的隐式锁操作要更加的面向对象。提供了显示的锁操作。
	final Lock lock = new ReentrantLock();//互斥锁。

	//通过lock锁获取监视器方法对象。Condition 负责生产者的监视操作。
	final Condition producer = lock.newCondition();

	//在创建一个监视器方法对象。负责消费者的监视操作。
	final Condition consumer = lock.newCondition();

	public  void set(String name)//
	{
		//通过锁对象进行显示的获取锁操作。
		lock.lock();
		try
		{
			while(flag)
				try{producer.await();}catch(Exception e){}//t1,t2
			this.name = name+"--"+count;//蛋糕1  蛋糕2 蛋糕3
			count++;

			System.out.println(Thread.currentThread().getName()+"---生产了，"+this.name);//生产蛋糕1 生产蛋糕2 生产蛋糕3
			//将标记改为true。
			flag = true;
			consumer.signal();//唤醒等待的线程。 
		}
		finally{
			//释放锁。
			lock.unlock();//定义在finally中，要求一定被释放。
		}
	}
	public  void get()//
	{
		lock.lock();
		try
		{
			while(!flag)
				try{consumer.await();}catch(Exception e){}//t3.t4
			System.out.println(Thread.currentThread().getName()+"------++++++-消费了....."+this.name);//消费蛋糕1
			flag = false;
			producer.signal();
		}
		finally
		{
			lock.unlock();
		}
	}
}

//定义生产者的任务。
class Producer implements Runnable
{
	private Resource r;
	Producer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.set("蛋糕");
		}
	}

}


//定义消费者的任务。
class Consumer implements Runnable
{
	private Resource r;
	Consumer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.get();
		}
	}
}

class ThreadDemo_Producer_Consumer3 
{
	public static void main(String[] args) 
	{
		Resource r = new Resource();
		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);

		//创建两个生产者线程。
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(pro);
		//创建两个消费者线程。
		Thread t3 = new Thread(con);
		Thread t4 = new Thread(con);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
