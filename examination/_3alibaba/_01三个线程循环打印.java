package _3alibaba;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class _01三个线程循环打印 implements Runnable {

	public static void main(String[] args) throws InterruptedException {
        _01三个线程循环打印 task = new _01三个线程循环打印();
        //创建三个线程并开启
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        thread1.setName("a");
        thread2.setName("l");
        thread3.setName("i");
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

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        lock.lock();
        try {
            for (int i = 0; i < 40 ; i++) {
            	if (name.equals("a")) {
            		//只要c线程没有执行,其他线程来就阻塞,只有c线程执行完了才会跳过
                    if ( !c ) condition.await(); 
                    //a线程执行结束
                    a = true;
                    //c线程没有执行
                    c = false;
                } else if (name.equals("l")) {
                	//只要a线程没有执行,其他线程来就阻塞,只有a线程执行完了才会跳过
                    if ( !a ) condition.await();
                    b = true;
                    a = false;
                } else if (name.equals("i")) {
                    if ( !b ) condition.await();
                    c = true;
                    b = false;
                }
                System.out.print(name);
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
