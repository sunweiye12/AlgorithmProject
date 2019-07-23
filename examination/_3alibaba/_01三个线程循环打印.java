package _3alibaba;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class _01三个线程循环打印 implements Runnable {

	public static void main(String[] args) throws InterruptedException {
        _01三个线程循环打印 task = new _01三个线程循环打印();
        //创建三个线程并开启
        Thread thread1 = new Thread(task,"1");
        Thread thread2 = new Thread(task,"2");
        Thread thread3 = new Thread(task,"3");
//        thread1.setName("1");
//        thread2.setName("2");
//        thread3.setName("3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
	
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    //为true代表执行完成
    private volatile Boolean a = false;
    private volatile Boolean b = false;
    private volatile Boolean c = true;
    private  int j = 1;

    @Override
    public void run() {
        lock.lock();
        try {
            for (int i = 0; i < 40 ; i++) {
            	//获取当前线程的名字
            	String name = Thread.currentThread().getName();
            	if (name.equals("1")) {
            		//只要c线程没有执行,其他线程来就阻塞,只有c线程执行完了才会跳过
                    if ( !c ) condition.await(); 
                    //a线程执行结束
                    a = true;
                    //c线程没有执行
                    c = false;
                } else if (name.equals("2")) {
                	//只要a线程没有执行,其他线程来就阻塞,只有a线程执行完了才会跳过
                    if ( !a ) condition.await();
                    b = true;
                    a = false;
                } else if (name.equals("3")) {
                    if ( !b ) condition.await();
                    c = true;
                    b = false;
                }
                System.out.print(j++ + " ");
                //通知正在等待的线程
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
