package _3alibaba;

public class 循环打印线程 {
	
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        Thread thread3 = new Thread(new Thread3());
        thread1.start();
        thread2.start();
        thread3.start();
        for(int i = 0;i < 100; i++){
        	thread1.join();
        	thread2.join();
        	thread3.join();
        }

    }

    public static class Thread1 implements Runnable{
        @Override
        public void run() {
        	while(true){
        		System.out.println("Thread1");
        	}
        }
    }

    public static class Thread2 implements Runnable{
        @Override
        public void run() {
        	while(true){
        		System.out.println("Thread2");
        	}
        }
    }

    public static class Thread3 implements Runnable{
        @Override
        public void run() {
        	while(true){
        		System.out.println("Thread3");
        	}
        }
    }

}
